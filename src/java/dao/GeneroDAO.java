/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Genero;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class GeneroDAO extends GenericDao<Genero>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(Genero genero)  throws Exception {
        save(genero);
    }
 
    public void alterar(Genero genero) {
        update(genero);
    }
 
    public void excluir(int id) {
        Genero c = findById(id);
        delete(c);
    }
    
    public List<Genero> listaGenerosPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
}
