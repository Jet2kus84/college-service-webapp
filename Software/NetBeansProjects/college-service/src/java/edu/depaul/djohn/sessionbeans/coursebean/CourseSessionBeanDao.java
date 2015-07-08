/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.djohn.sessionbeans.coursebean;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Deonte Johnson
 * 
 * This is a remote session bean
 * 
 */
@Remote
public interface CourseSessionBeanDao {
    
    public abstract boolean add(
            String CourseName, 
            String CourseNumber,
            String CourseCategory, 
            String CourseDescription);
    
    public <T> boolean remove(Class<T> cls, String id);
    public <T> T find(Class<T> cls, String id);
    public <T> List<T> findAll(Class<T> cls, String DatabaseTableName);
    public abstract <T> void update(Class<T> cls, String id);
}
