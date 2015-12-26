/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDAO;
import dao.StatusLeituraDAO;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Status;
import modelo.StatusLeitura;

/**
 *
 * @author Lucas
 */
public class StatusLeituraController {
     public static void salvar(String nome){
        StatusLeitura s = new StatusLeitura(nome);
        new StatusLeituraDAO().salvar(s);
    }
    
    public static void editar(String id, String nome){
        StatusLeitura s = new StatusLeitura(Integer.parseInt(id), nome);
        new StatusLeituraDAO().alterar(s);
    }
    
    public static void excluir(String id){
        new StatusLeituraDAO().excluir(Integer.parseInt(id));
    }
    
    public static String retornaCampo(String id, String campo){
        String retorno = "";
        StatusLeituraDAO dao = new StatusLeituraDAO();
        StatusLeitura s = dao.findById(Integer.parseInt(id));
       
        try {
            Class<?> classe = StatusLeitura.class;
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
        
        StatusLeituraDAO dao = new StatusLeituraDAO();
        List<StatusLeitura> statusleituras = dao.findAll();
        String retorno = "";
        for(int i=0; i< statusleituras.size(); i++){
            retorno += "<option value='"+statusleituras.get(i).getId() +"'>"+statusleituras.get(i).getNome()+"</option>";
        }
        return retorno;
    }
        
}
