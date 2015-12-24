/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import modelo.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

/**
 *
 * @author lucas
 */
public class Collecthings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Configuration config = new Configuration();
       config.addAnnotatedClass(Autor.class);
       config.addAnnotatedClass(Categoria.class);
       config.addAnnotatedClass(Editora.class);
       config.addAnnotatedClass(Genero.class);
       config.addAnnotatedClass(Status.class);
       config.addAnnotatedClass(StatusLeitura.class);
       config.addAnnotatedClass(Usuario.class);
       config.addAnnotatedClass(Livro.class);
       
        
       config.configure("hibernate.cfg.xml");
       config.configure("hibernate.cfg.xml");
        
       new SchemaExport(config).create(true, true);
       
       Autor a = new Autor(0, "teste");
       AutorDAO autordao = new AutorDAO();
       autordao.salvar(a);
        
      new SchemaUpdate(config).execute(true, true);
    }
    
}
