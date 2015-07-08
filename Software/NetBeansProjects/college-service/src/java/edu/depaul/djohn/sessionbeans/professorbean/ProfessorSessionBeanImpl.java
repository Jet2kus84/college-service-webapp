package edu.depaul.djohn.sessionbeans.professorbean;

import edu.depaul.djohn.entity.Professor;
import edu.depaul.djohn.sessionbeans.SessionBean;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 *
 * @author Deonte Johnson
 */
@Stateless
public class ProfessorSessionBeanImpl extends SessionBean 
    implements ProfessorSessionBeanDao {

        @Override
        public boolean add(
            String firstName, 
            String lastName, 
            int id) {
        
            Professor prof = new Professor();
        
            prof.setFirstName(firstName);
            prof.setLastName(lastName);
            prof.setID(id);
            
            //object can not be null
            //if(entity == null) return false;
            
            //object can not already exist in database
            if(this.find(Professor.class, String.valueOf(
                    prof.getId())) != null) return false;
            
            //open link to db
            this.openEntityManager();
            
            //add course to database
            entitymanager.getTransaction().begin();
            entitymanager.persist( prof );
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
                    //((Professor) obj).setCourseDescription("I changed something");
                    entitymanager.getTransaction( ).commit( );
		}
		
		this.closeEntityManager();
    }
    
}
