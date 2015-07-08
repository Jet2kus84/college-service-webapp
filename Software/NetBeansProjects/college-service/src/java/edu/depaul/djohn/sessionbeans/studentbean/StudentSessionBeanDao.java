/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.djohn.sessionbeans.studentbean;

import javax.ejb.Stateless;

/**
 *
 * @author Deonte Johnson
 */
@Stateless
public interface StudentSessionBeanDao {
    public abstract boolean add(
                String firstName, 
                String lastName,
                String middleInitial,
                String dob,
                String year);
    
    public <T> boolean remove(Class<T> cls, String id);
    public <T> T find(Class<T> cls, String id);
    public <T> java.util.List<T> findAll(Class<T> cls, String DatabaseTableName);
    public <T> void update(Class<T> cls, String id);
}
