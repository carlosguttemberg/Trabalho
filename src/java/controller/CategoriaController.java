/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoriaDAO;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;

/**
 *
 * @author Lucas
 */
public class CategoriaController {
    public static void salvar(String nome){
        Categoria ca = new Categoria(nome);
        new CategoriaDAO().salvar(ca);
    }
    
    public static void editar(String id, String nome){
        Categoria ca = new Categoria(Integer.parseInt(id), nome);
        new CategoriaDAO().alterar(ca);
    }
    
    public static void excluir(String id){
        new CategoriaDAO().excluir(Integer.parseInt(id));
    }
    
    public static String retornaCampo(String id, String campo){
        String retorno = "";
        CategoriaDAO dao = new CategoriaDAO();
        Categoria ca = dao.findById(Integer.parseInt(id));
       
        try {
            Class<?> classe = Categoria.class;
            Field atributo;
            atributo = classe.getDeclaredField(campo);
            atributo.setAccessible(true);
            Object value;    
            value = atributo.get(ca);
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
        
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> categorias = dao.findAll();
        String retorno = "";
        for(int i=0; i< categorias.size(); i++){
            retorno += "<option value='"+categorias.get(i).getId() +"'>"+categorias.get(i).getNome()+"</option>";
        }
        return retorno;
    }
}
