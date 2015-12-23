/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Autor;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class AutorDAO extends GenericDao<Autor>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(Autor autor) {
        save(autor);
    }
 
    public void alterar(Autor autor) {
        update(autor);
    }
 
    public void excluir(int id) {
        Autor c = findById(id);
        delete(c);
    }
    
    public List<Autor> listaAutorsPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
}
