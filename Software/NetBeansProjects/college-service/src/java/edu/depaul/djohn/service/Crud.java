package edu.depaul.djohn.service;

import edu.depaul.djohn.entity.Course;
import edu.depaul.djohn.entity.Password;
import edu.depaul.djohn.entity.Student;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//This class is going to be removed, no longer needed
public class Crud {

	private static Crud instance;
	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;
        private final String persistencePU = "college-service";
	
	/**
	 *  Open and allow access to the database for transaction
	 */
	private void openEntityManager() {
		//change into a method and make the parameter the fields needed to create an object
		emfactory = Persistence.createEntityManagerFactory( persistencePU );    
		entitymanager = emfactory.createEntityManager( );
	}
	
	/**
	 * Close access to the database, appropriately logging out
	 */
	private void closeEntityManager() {
		entitymanager.close();
		emfactory.close();
	}
	
	private Crud() { 
		
	}
	
	public static Crud getInstance() {
		if(instance == null) 
			instance = new Crud();
		return instance;
	}
	
        /**
         * 
         * @param entity 
         */
        public void create(edu.depaul.djohn.entity.Entity entity) {
            this.openEntityManager();
		
		entitymanager.getTransaction().begin();
		entitymanager.persist( entity );
		entitymanager.getTransaction( ).commit( );

		this.closeEntityManager();
        }
        
	/**
	 * 
	 * @param cls object class to be found
	 * @param id object id number
	 * @return requested object
	 */
	public <T> T find(Class<T> cls, String id) {
		this.openEntityManager();
		
		Object obj = null;
	      
		if(cls.equals(Course.class)) {
			obj = cls.cast(entitymanager.find( cls, Integer.parseInt(id)));
		}
		else if(cls.equals(Student.class)){
			obj = cls.cast(entitymanager.find( cls, id));
		}
		
		this.closeEntityManager();
		return cls.cast(obj);
	}
	
	/**
	 * 
	 * @param <T> class of the objects being retrieved
         * @param cls
        * @param tableName  
	 * @return all objects available in the database
	 */
	public <T> ArrayList<T> findAll(Class<T> cls, String tableName) {
		this.openEntityManager();
		
	    javax.persistence.Query query = entitymanager.createQuery("SELECT e FROM " + tableName +" e");
	   
	    ArrayList<T> objects = new ArrayList<>();
	    
	    //check and ensure that each object is an instance of Course
	    for(Object o : query.getResultList()) {
	    	objects.add(cls.cast(o));
	    }
	    
	    this.closeEntityManager();
	    return objects;
	  }
	
	/**
	 * 
        * @param <T>
	 * @param cls object class to be deleted
	 * @param id object id number
	 */
	public <T> void delete(Class<T> cls, String id) {
		this.openEntityManager();
		
		entitymanager.getTransaction( ).begin( );
                Object obj = null;
                
                if(cls.equals(Password.class)) {
			obj = cls.cast(entitymanager.find( cls, id));
		} else {
                    obj = cls.cast(entitymanager.find( cls, Integer.parseInt(id)));
                }
	      
		if(obj == null) {
			return; //prevent null exception
		}
		else {
			entitymanager.remove( obj );
			entitymanager.getTransaction( ).commit( );
	      }
		
		this.closeEntityManager();
	}
	
	/**
	 * 
        * @param <T>
	 * @param cls cls object class to be update
	 * @param id object id number
	 * 
	 * try to modify up so that it works with all entities
	 */
	public <T> void update(Class<T> cls, int id) {
		this.openEntityManager();
		
		entitymanager.getTransaction( ).begin( );
		Object obj = cls.cast(entitymanager.find( cls, id ));
	      
		if(obj == null) {
			return;
		}
		else {
			//before update
			System.out.println( obj );
			((Course) obj).setCourseDescription("I changed something");
			entitymanager.getTransaction( ).commit( );
	      
			//after update
			System.out.println( obj );
		}
		
		this.closeEntityManager();
	}
}
