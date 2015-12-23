/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Categoria;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class CategoriaDAO extends GenericDao<Categoria>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(Categoria categoria) {
        save(categoria);
    }
 
    public void alterar(Categoria categoria) {
        update(categoria);
    }
 
    public void excluir(int id) {
        Categoria c = findById(id);
        delete(c);
    }
    
    public List<Categoria> listaCategoriasPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
}
