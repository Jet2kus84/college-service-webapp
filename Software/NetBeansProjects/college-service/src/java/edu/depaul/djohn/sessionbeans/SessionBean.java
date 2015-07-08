
package edu.depaul.djohn.sessionbeans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Deonte Johnson
 */
public abstract class SessionBean {
    private final String persistencePU = "college-service";
    private EntityManagerFactory emfactory;
    protected EntityManager entitymanager;
    
    protected void openEntityManager() {
	emfactory = Persistence.createEntityManagerFactory( persistencePU );    
	entitymanager = emfactory.createEntityManager( );
    }
    
    protected void closeEntityManager() {
	entitymanager.close();
	emfactory.close();
    }
}
