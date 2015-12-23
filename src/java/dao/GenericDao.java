/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author lsiqueira
 */

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.lang.Object;
import org.hibernate.transform.Transformers;
//import util.HibernateUtil;
 
public class GenericDao<T extends Serializable> {
 
    @PersistenceContext(unitName = "collecthings")
    private final EntityManager entityManager;
    private final Class<T> persistentClass;
 
    public GenericDao() {
        this.entityManager = EntityManagerUtil.getEntityManager();
        this.persistentClass = (Class<T>) ((ParameterizedType) 
            getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
 
    public EntityManager getEntityManager() {
        return entityManager;
    }
 
    protected void save(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();
 
        try {
            tx.begin();
            getEntityManager().persist(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }
 
    protected void update(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();
 
        try {
            tx.begin();
            getEntityManager().merge(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
 
    }
 
    protected void delete(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();
 
        try {
            tx.begin();
            getEntityManager().remove(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }
 
    public List<T> findAll() throws Exception {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(persistentClass)./*setResultTransformer(Transformers.aliasToBean(persistentClass)).*/list();
    }
 
    public T findByName(String nome) {
        Session session = (Session) getEntityManager().getDelegate();
        return (T) session.createCriteria(persistentClass)
            .add(Restrictions.eq("nome", nome).ignoreCase()).uniqueResult();
    }
 
    public T findById(int id) {
        Session session = (Session) getEntityManager().getDelegate();
        return (T) session.createCriteria(persistentClass)
            .add(Restrictions.eq("id", id)).uniqueResult();
    }
 
    private void close() {
        if (getEntityManager().isOpen()) {
            getEntityManager().close();
        }
       // shutdown();
    }
    
    
 
   /* private void shutdown() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createNativeQuery("SHUTDOWN").executeUpdate();
        em.close();
    }*/

    public Class<T> getPersistentClass() {
        return persistentClass;
    }
}
