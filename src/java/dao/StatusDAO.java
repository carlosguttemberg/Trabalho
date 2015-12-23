/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Status;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class StatusDAO extends GenericDao<Status>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(Status status) {
        save(status);
    }
 
    public void alterar(Status status) {
        update(status);
    }
 
    public void excluir(int id) {
        Status c = findById(id);
        delete(c);
    }
    
    public List<Status> listaStatussPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
}
