/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
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
    
}
