/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDAO;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Status;

/**
 *
 * @author Lucas
 */
public class StatusController {
    public static void salvar(String nome){
        Status s = new Status(nome);
        new StatusDAO().salvar(s);
    }
    
    public static void editar(String id, String nome){
        Status s = new Status(Integer.parseInt(id), nome);
        new StatusDAO().alterar(s);
    }
    
    public static void excluir(String id){
        new StatusDAO().excluir(Integer.parseInt(id));
    }
    
    public static String retornaCampo(String id, String campo){
        String retorno = "";
        StatusDAO dao = new StatusDAO();
        Status s = dao.findById(Integer.parseInt(id));
       
        try {
            Class<?> classe = Status.class;
            Field atributo;
            atributo = classe.getDeclaredField(campo);
            atributo.setAccessible(true);
            Object value;    
            value = atributo.get(s);
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
        
        StatusDAO dao = new StatusDAO();
        List<Status> status = dao.findAll();
        String retorno = "";
        for(int i=0; i< status.size(); i++){
            retorno += "<option value='"+status.get(i).getId() +"'>"+status.get(i).getNome()+"</option>";
        }
        return retorno;
    }
}
