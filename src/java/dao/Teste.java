/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import controller.UsuarioController;
import modelo.*;
import controller.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

/**
 *
 * @author lucas
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

       Configuration config = new Configuration();

       /*Configuration config = new Configuration();
       
>>>>>>> origin/master
=======
       /*Configuration config = new Configuration();
       
>>>>>>> origin/master
       config.addAnnotatedClass(Autor.class);
       config.addAnnotatedClass(Categoria.class);
       config.addAnnotatedClass(Editora.class);
       config.addAnnotatedClass(Genero.class);
       config.addAnnotatedClass(Status.class);
       config.addAnnotatedClass(StatusLeitura.class);
       config.addAnnotatedClass(Usuario.class);
       config.addAnnotatedClass(Livro.class);
       
        
<<<<<<< HEAD
       config.configure("hibernate.cfg.xml");
       config.configure("hibernate.cfg.xml");
=======
        //config.configure("hibernate.cfg.xml");
        config.configure("hibernate.cfg.xml");
<<<<<<< HEAD
>>>>>>> origin/master
        
<<<<<<< HEAD
       new SchemaExport(config).create(true, true);
       
       Autor a = new Autor(0, "teste");
       AutorDAO autordao = new AutorDAO();
       autordao.salvar(a);
=======
=======
        
>>>>>>> origin/master
        // PARA CRIAR AS TABELAS NO BANCO SÓ DESCOMENTAR A LINHA ABAIXO -- PRECISA CRIAR O BANCO PRIMEIRO
       // new SchemaExport(config).create(true, true);
       //E PARA ATUALIZAR, A LINHA ABAIXO
       //new SchemaUpdate(config).execute(true, true);*/
       
       
       
       //Autor a = new Autor(0, "teste");
       //AutorDAO autordao = new AutorDAO();
       //autordao.salvar(a);
       
       /*Testando o login
       //UsuarioController.salvar("teste", "teste", "teste", "img/fotopadrao.jpeg", "teste@teste");
       if(UsuarioController.validaUsuario("teste", "teste")){
           System.out.println("usuario logado com sucesso");
       }else{
           System.out.println("login ou senha incorreto");
       }
        */


        

     // new SchemaUpdate(config).execute(true, true);


    }
    
}
