/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.djohn.ejb;

import edu.depaul.djohn.entity.Password;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jet2kus84
 */
/*@Stateless
@LocalBean
public class PasswordEJB implements IPasswordEJB {
   
    //pass persistence unit to entityManager.
   @PersistenceContext(unitName="college-servicePU")
   private EntityManager em;  
   
   @Override
   public void addPassword(Password password) {
           em.persist(password);
   }
   
   @Override
   public java.util.List<Password> getPasswords() {        
      return em.createQuery("From PASSWORD").getResultList();
   }
   
   public static void main(String[] args) throws NamingException {
      
       // GreeterBean instance = (GreeterBean) ctx.lookup("java:global/classes/GreeterBean");
       //add a password to the data
       Password pwd = new Password();
       pwd.setType("TEST");
       pwd.setUsername("djohn130");
       pwd.setPassword("eaglewing");
       
       new PasswordEJB().addPassword(pwd);    
   } 
}
*/