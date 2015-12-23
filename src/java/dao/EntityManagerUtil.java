/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author lsiqueira
 */
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class EntityManagerUtil {
  private static EntityManagerFactory emf;
 
    public static EntityManager getEntityManager() {
         if (emf == null){
                  emf = Persistence.createEntityManagerFactory("collecthings");
         }
         return emf.createEntityManager();
    }
}