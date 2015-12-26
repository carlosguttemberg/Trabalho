/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LivroDAO;
import dao.UsuarioDAO;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Livro;
import modelo.Usuario;

/**
 *
 * @author Lucas
 */
public class UsuarioController {
    public static void salvar(String nome, String login, String senha, String caminhofoto, String email){
        Usuario a = new Usuario(nome, login, senha, caminhofoto, email);
        new UsuarioDAO().salvar(a);
    }
    
    public static void editar(String id, String nome, String login, String senha, String caminhofoto, String email){
        Usuario a = new Usuario(Integer.parseInt(id), nome, login, senha, caminhofoto, email);
        new UsuarioDAO().alterar(a);
    }
    public static void excluir(String id){
        new UsuarioDAO().excluir(Integer.parseInt(id));
    }
    
    public static boolean validaUsuario(String login, String senha){
         UsuarioDAO dao = new UsuarioDAO();
         Usuario u = dao.findByCollumPalavra("login", login);
        if(u != null){
          if(u.getSenha().equals(senha))  
            return true;
        }
        return false;
    }
    
    public static int retornaId(String login){
        UsuarioDAO dao = new UsuarioDAO();
         Usuario u = dao.findByCollumPalavra("login", login);
         return u.getId();
    }
    
    public static String retornaCampo(String id, String campo){
        String retorno = "";
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.findById(Integer.parseInt(id));
       
        try {
            Class<?> classe = Usuario.class;
            Field atributo;
            atributo = classe.getDeclaredField(campo);
            atributo.setAccessible(true);
            Object value;    
            value = atributo.get(u);
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
        
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.findAll();
        String retorno = "";
        for(int i=0; i< usuarios.size(); i++){
            retorno += "<option value='"+usuarios.get(i).getId() +"'>"+usuarios.get(i).getNome()+"</option>";
        }
        return retorno;
    }
     
     /*Usar esta função para permitir que o usuário vincule um livor criado por outro usuário a conta dele
     */
     
     public static void vinculaLivro(String idLivro, String idUsuario){
        UsuarioDAO dao = new UsuarioDAO(); 
        Usuario usuario = dao.findById(Integer.parseInt(idUsuario));
        LivroDAO livrodao = new LivroDAO();
        Livro livro = livrodao.findById(Integer.parseInt(idLivro));
        usuario.adicionaLivro(livro);
        dao.alterar(usuario);
        
     }
    
}
