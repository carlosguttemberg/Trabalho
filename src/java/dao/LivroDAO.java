/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Livro;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class LivroDAO extends GenericDao<Livro>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(Livro livro)  throws Exception{
        save(livro);
    }
 
    public void alterar(Livro livro) {
        update(livro);
    }
 
    public void excluir(int id) {
        Livro c = findById(id);
        delete(c);
    }
    
    public List<Livro> listaLivrosPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
     public List<Livro> listaLivrosPorIdUsuario(int idUsuario){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.eq("idUsuario", idUsuario)).list();
        
    }
}
