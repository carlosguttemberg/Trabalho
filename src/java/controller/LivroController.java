/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LivroDAO;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.*;
import java.util.List;
import modelo.Autor;
import modelo.Categoria;
import modelo.Editora;
import modelo.Livro;
import modelo.Status;
import modelo.StatusLeitura;

/**
 *
 * @author Lucas
 */
public class LivroController {
      public static String salvar(String titulo, String ano, String volume, String paginas, String edicao, String caminhofoto, String idAutor, String idEditora, String idCategoria, String idStatus, String idStatusLeitura, String idUsuario){
          String retorno = "";
        try {
            AutorDAO autordao = new AutorDAO();
            Autor autor = autordao.findById(Integer.parseInt(idAutor));
            EditoraDAO editoradao = new EditoraDAO();
            Editora editora = editoradao.findById(Integer.parseInt(idEditora));
            CategoriaDAO categoriadao = new CategoriaDAO();
            Categoria categoria = categoriadao.findById(Integer.parseInt(idCategoria));
            StatusDAO statusdao = new StatusDAO();
            Status status = statusdao.findById(Integer.parseInt(idStatus));
            StatusLeituraDAO statusleituradao = new StatusLeituraDAO();
            StatusLeitura statusleitura = statusleituradao.findById(Integer.parseInt(idStatusLeitura));


            Livro l = new Livro(titulo, Integer.parseInt(ano), Integer.parseInt(volume), Integer.parseInt(paginas), edicao, caminhofoto, autor, editora, categoria, status, statusleitura);
            new LivroDAO().salvar(l);
            UsuarioController.vinculaLivro(LivroController.retornaId(titulo)+"", new UsuarioDAO().findById(Integer.parseInt(idUsuario)).getId()+"");
          } catch (Exception e) {
                retorno += "Livro já existente.";
                return retorno;
              
          }
          return retorno;
        
        
    }
    
    public static void editar(String id, String titulo, String ano, String volume, String paginas, String edicao, String caminhofoto, String idAutor, String idEditora, String idCategoria, String idStatus, String idStatusLeitura){
        AutorDAO autordao = new AutorDAO();
        Autor autor = autordao.findById(Integer.parseInt(idAutor));
        EditoraDAO editoradao = new EditoraDAO();
        Editora editora = editoradao.findById(Integer.parseInt(idEditora));
        CategoriaDAO categoriadao = new CategoriaDAO();
        Categoria categoria = categoriadao.findById(Integer.parseInt(idCategoria));
        StatusDAO statusdao = new StatusDAO();
        Status status = statusdao.findById(Integer.parseInt(idStatus));
        StatusLeituraDAO statusleituradao = new StatusLeituraDAO();
        StatusLeitura statusleitura = statusleituradao.findById(Integer.parseInt(idStatusLeitura));
        
        Livro l = new Livro(Integer.parseInt(id), titulo, Integer.parseInt(ano), Integer.parseInt(volume), Integer.parseInt(paginas), edicao, caminhofoto, autor, editora, categoria, status, statusleitura);
        new LivroDAO().alterar(l);
    }
    
    public static void excluir(String id){
        new LivroDAO().excluir(Integer.parseInt(id));
    }
    
    public static String retornaCampo(String id, String campo){
        String retorno = "";
        LivroDAO dao = new LivroDAO();
        Livro l = dao.findById(Integer.parseInt(id));
       
        try {
            Class<?> classe = Livro.class;
            Field atributo;
            atributo = classe.getDeclaredField(campo);
            atributo.setAccessible(true);
            Object value;    
            value = atributo.get(l);
            retorno = value.toString();

        } catch (NoSuchFieldException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
     public static String retornaSelect(){
        
        LivroDAO dao = new LivroDAO();
        List<Livro> livros = dao.findAll();
        String retorno = "";
        for(int i=0; i< livros.size(); i++){
            retorno += "<option value='"+livros.get(i).getId() +"'>"+livros.get(i).getTitulo()+"</option>";
        }
        return retorno;
    }
     
      public static int retornaId(String titulo){
        LivroDAO dao = new LivroDAO();
         Livro u = dao.findByCollumPalavra("titulo", titulo   );
         return u.getId();
    }
}
