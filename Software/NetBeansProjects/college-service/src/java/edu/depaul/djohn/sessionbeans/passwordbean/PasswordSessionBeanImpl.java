
package edu.depaul.djohn.sessionbeans.passwordbean;

import edu.depaul.djohn.entity.Entity;
import edu.depaul.djohn.entity.Password;
import edu.depaul.djohn.sessionbeans.SessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Deonte Johnson
 */
@Stateless
public class PasswordSessionBeanImpl extends SessionBean 
    implements PasswordSessionBeanDao {

   // private ArrayList<Password> table;
    
    public PasswordSessionBeanImpl() {
       // table = new ArrayList<>();
        if((findAll(Password.class, "PASSWORD") == null) ||
                        findAll(Password.class, "PASSWORD").isEmpty()) {
            this.add("professor", "prof2015", "Professor");
            this.add("student", "stu2015", "Student");
            this.add("advisor", "adv2015", "Advisor");
        }   
    }
    
    /**
     * 
     * @param username
     * @param password 
     * @param type 
     */
    public final void add(String username, String password, String type) {
        Password authorize = new Password();
        authorize.setUsername(username);
        authorize.setPassword(password);
        authorize.setType(type);
        this.add(authorize); //add to database
    }
    
        @Override
        public boolean add(Entity entity) {
            
            //object can not be null
            if(entity == null) return false;
            
            //object can not already exist in database
            if(this.find(Password.class, String.valueOf(
                    entity.getId())) != null) return false;
            
            //open link to db
            this.openEntityManager();
            
            //add course to database
            entitymanager.getTransaction().begin();
            entitymanager.persist( entity );
            entitymanager.getTransaction( ).commit( );
            
            //close link to db
            this.closeEntityManager();
            
            //course has been sucessfully added to database
            return true;
        }

   @Override
	public <T> boolean remove(Class<T> cls, String id) {
		this.openEntityManager();
		
		entitymanager.getTransaction( ).begin( );
                Object obj = null;
                
                obj = cls.cast(entitymanager.find( cls, id));
              
		if(obj == null) {
                    return false; //prevent null exception
		}
		else {
                    entitymanager.remove( obj );
                    entitymanager.getTransaction( ).commit( );
	      }
                this.closeEntityManager();
                
                //course successfully removed
                return true;
	}
        
        @Override
	public <T> T find(Class<T> cls, String id) {
            this.openEntityManager();
		
		Object obj = null;
	     
                obj = cls.cast(entitymanager.find( cls, id));
		
		this.closeEntityManager();
		return cls.cast(obj);
        }
        
        @Override
        public <T> List<T> findAll(Class<T> cls, String tableName) {
		this.openEntityManager();
                @SuppressWarnings("JPQLValidation")
                javax.persistence.Query query = entitymanager.createQuery("SELECT e FROM " + tableName +" e");
	   
                ArrayList<T> objects = new ArrayList<>();
	    
            //check and ensure that each object is an instance of Course
                query.getResultList().stream().forEach((o) -> {
                    objects.add(cls.cast(o));
            });
	    
                this.closeEntityManager();
                return objects;
	  }
        
        @Override
        public <T> void update(Class<T> cls, String id) {
            this.openEntityManager();
		
            entitymanager.getTransaction( ).begin( );
            Object obj = cls.cast(entitymanager.find( cls, id ));
	      
            if(obj == null) {
		return;
            }
            else {
                entitymanager.getTransaction( ).commit( );
            }
		
            this.closeEntityManager();
         }   
        
    /*public void set
        Table(java.util.ArrayList object) {
        if(this.table.isEmpty() || this.table == null)
            this.table = object;
    }*/
}
