/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.djohn.sessionbeans.professorbean;

import javax.ejb.Remote;

/**
 *
 * @author Deonte Johnson
 */
@Remote
public interface ProfessorSessionBeanDao {
    public abstract boolean add(
             String firstName, 
             String lastName, 
             int id);
    
     public <T> boolean remove(Class<T> cls, String id);
     public <T> T find(Class<T> cls, String id);
     public <T> java.util.List<T> findAll(Class<T> cls, String DatabaseTableName);
     public abstract <T> void update(Class<T> cls, String id);
}
