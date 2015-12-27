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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
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
 
    protected String save(T entity) throws Exception{
        EntityTransaction tx = getEntityManager().getTransaction();
        String retorno = "";
        try {
            tx.begin();
            getEntityManager().persist(entity);
            tx.commit();
        } catch (Exception e/*Throwable t*/) {
            //t.printStackTrace();
            //retorno += t.getMessage();
            tx.rollback();
            throw new Exception(e.getMessage() , e);
            
    
        } finally {
            close();
        }
        return retorno;
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
 
    public List<T> findAll(){
        List retorno = null;
        try {
            Session session = (Session) getEntityManager().getDelegate();
            retorno = session.createCriteria(persistentClass)./*setResultTransformer(Transformers.aliasToBean(persistentClass)).*/list();
        } catch (Exception e) {
        }
        return retorno;
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
    
    public T findByCollumPalavra(String coluna, String palavra) {
        Session session = (Session) getEntityManager().getDelegate();
        return (T) session.createCriteria(persistentClass)
            .add(Restrictions.eq(coluna, palavra).ignoreCase()).uniqueResult();
    }
    
    public T findByCollumId(int id, String coluna) {
        Session session = (Session) getEntityManager().getDelegate();
         ProjectionList proList = Projections.projectionList();
         proList.add(Projections.property(coluna)); 
        return (T) session.createCriteria(persistentClass)
            .setProjection(proList).add(Restrictions.eq(coluna, id).ignoreCase()).uniqueResult();
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
