/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EditoraDAO;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Editora;

/**
 *
 * @author Lucas
 */
public class EditoraController {
    public static void salvar(String nome){
        Editora e = new Editora(nome);
        new EditoraDAO().salvar(e);
    }
    
    public static void editar(String id, String nome){
        Editora e = new Editora(Integer.parseInt(id), nome);
        new EditoraDAO().alterar(e);
    }
    
    public static void excluir(String id){
        new EditoraDAO().excluir(Integer.parseInt(id));
    }
    
    public static String retornaCampo(String id, String campo){
        String retorno = "";
        EditoraDAO dao = new EditoraDAO();
        Editora e = dao.findById(Integer.parseInt(id));
       
        try {
            Class<?> classe = Editora.class;
            Field atributo;
            atributo = classe.getDeclaredField(campo);
            atributo.setAccessible(true);
            Object value;    
            value = atributo.get(e);
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
}
