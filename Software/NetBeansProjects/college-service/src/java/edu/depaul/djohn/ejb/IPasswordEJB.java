/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.djohn.ejb;

import edu.depaul.djohn.entity.Password;

/**
 *
 * @author Jet2kus84
 */
public interface IPasswordEJB {
    
   public void addPassword(Password password);

   public java.util.List<Password> getPasswords();
}
