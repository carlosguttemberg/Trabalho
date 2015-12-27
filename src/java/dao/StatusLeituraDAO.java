/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.StatusLeitura;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class StatusLeituraDAO extends GenericDao<StatusLeitura>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(StatusLeitura statusleitura) throws Exception{
        save(statusleitura);
    }
 
    public void alterar(StatusLeitura statusleitura) {
        update(statusleitura);
    }
 
    public void excluir(int id) {
        StatusLeitura c = findById(id);
        delete(c);
    }
    
    public List<StatusLeitura> listaStatusLeiturasPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
}
