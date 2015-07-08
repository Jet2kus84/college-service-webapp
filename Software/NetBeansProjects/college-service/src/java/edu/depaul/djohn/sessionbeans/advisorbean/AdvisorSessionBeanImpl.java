
package edu.depaul.djohn.sessionbeans.advisorbean;

import edu.depaul.djohn.entity.Advisor;
import edu.depaul.djohn.entity.Course;
import edu.depaul.djohn.sessionbeans.SessionBean;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 *
 * @author Jet2kus84
 */
@Stateless
public class AdvisorSessionBeanImpl extends SessionBean 
    implements AdvisorSessionBeanDao {

    @Override
    public boolean add(
            String firstName, 
            String lastName, 
            int id) {
        
            Advisor advisor = new Advisor();
            advisor.setFirstName(firstName);
            advisor.setLastName(lastName);
            
            if(id > 0 ) advisor.setID(id);
            
            //object can not already exist in database
            if(this.find(Advisor.class, String.valueOf(
                    advisor.getId())) != null) return false;
            
            //open link to db
            this.openEntityManager();
            
            //add course to database
            entitymanager.getTransaction().begin();
            entitymanager.persist( advisor );
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
                
                try {
                    obj = cls.cast(entitymanager.find( cls, 
                        Integer.parseInt(id))); //id is an int
                } catch (NumberFormatException e) {
                    obj = cls.cast(entitymanager.find( cls, id)); //id is a string
                }
                
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
	      
                try {
                    obj = cls.cast(entitymanager.find( cls, 
                        Integer.parseInt(id))); //id is an int
                } catch (NumberFormatException e) {
                    obj = cls.cast(entitymanager.find( cls, id)); //id is a string
                }
		
		this.closeEntityManager();
		return cls.cast(obj);
    }

        @Override
    public <T> List<T> findAll(Class<T> cls, String DatabaseTableName) {
        this.openEntityManager();
                @SuppressWarnings("JPQLValidation")
                javax.persistence.Query query = entitymanager.createQuery
                    ("SELECT e FROM " + DatabaseTableName +" e");
	   
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
