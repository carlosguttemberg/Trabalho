    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Editora;
//import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas
 */
public class EditoraDAO extends GenericDao<Editora>{
    //public class ClienteDAO extends GenericDao<Cliente> {
    public void salvar(Editora editora) {
        save(editora);
    }
 
    public void alterar(Editora editora) {
        update(editora);
    }
 
    public void excluir(int id) {
        Editora c = findById(id);
        delete(c);
    }
    
    public List<Editora> listaEditorasPorNome(String nome){
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(this.getPersistentClass()).add(Restrictions.sqlRestriction("nome like '" + nome + "%'")).list();
        
    }
}
