/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class UsuarioDAO extends GenericDao<Usuario>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(Usuario usuario) {
        save(usuario);
    }
 
    public void alterar(Usuario usuario) {
        update(usuario);
    }
 
    public void excluir(int id) {
        Usuario c = findById(id);
        delete(c);
    }
    
    public List<Usuario> listaUsuariosPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
    
    
}
