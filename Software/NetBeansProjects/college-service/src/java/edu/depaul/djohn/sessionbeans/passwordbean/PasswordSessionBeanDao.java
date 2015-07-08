/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.djohn.sessionbeans.passwordbean;

import edu.depaul.djohn.entity.Entity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jet2kus84
 */
@Remote
public interface PasswordSessionBeanDao {
    public abstract boolean add(Entity entity);
    
    public <T> boolean remove(Class<T> cls, String id);
    public <T> T find(Class<T> cls, String id);
    public <T> List<T> findAll(Class<T> cls, String DatabaseTableName);
    public abstract <T> void update(Class<T> cls, String id);
    
}
