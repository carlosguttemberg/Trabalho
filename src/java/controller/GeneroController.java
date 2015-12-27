/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeneroDAO;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Genero;

/**
 *
 * @author Lucas
 */
public class GeneroController {
    public static void salvar(String nome){
        Genero g = new Genero(nome);
        try {
            new GeneroDAO().salvar(g);
        } catch (Exception ex) {
            Logger.getLogger(GeneroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void editar(String id, String nome){
        Genero g = new Genero(Integer.parseInt(id), nome);
        new GeneroDAO().alterar(g);
    }
    
    public static void excluir(String id){
        new GeneroDAO().excluir(Integer.parseInt(id));
    }
    
    public static String retornaCampo(String id, String campo){
        String retorno = "";
        GeneroDAO dao = new GeneroDAO();
        Genero g = dao.findById(Integer.parseInt(id));
       
        try {
            Class<?> classe = Genero.class;
            Field atributo;
            atributo = classe.getDeclaredField(campo);
            atributo.setAccessible(true);
            Object value;    
            value = atributo.get(g);
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
        
        GeneroDAO dao = new GeneroDAO();
        List<Genero> generos = dao.findAll();
        String retorno = "";
        for(int i=0; i< generos.size(); i++){
            retorno += "<option value='"+generos.get(i).getId() +"'>"+generos.get(i).getNome()+"</option>";
        }
        return retorno;
    }
}
