package edu.depaul.djohn.sessionbeans.coursebean;

import edu.depaul.djohn.entity.Course;
import edu.depaul.djohn.sessionbeans.SessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * 
 * @author Deonte Johnson
 * 
 * This class will be used to add courses to the
 * student catalog
 * 
 * // Get a naming context
      InitialContext ctx = new InitialContext();
      // Get a Calculator
      calculator
         = (Calculator) ctx.lookup(Calculator.class.getName());
 *
 */

@Stateless
public class CourseSessionBeanImpl extends SessionBean
    implements CourseSessionBeanDao {

        //List of courses offered
        private final List<Course> courses;
	
	//create a list of identifiers for use with course searching
        private final List<String> identifiers;
      
        /**
	 * 
	 */
	public CourseSessionBeanImpl() {
		courses = new ArrayList<>();
		identifiers = new ArrayList<>();
	}
        
        /**
         * 
         * @param CourseName
         * @param CourseNumber
         * @param CourseCategory
         * @param CourseDescription
         * @return true if course has been added successfully
         * false if the course
         * already exist in the database.
         */
        @Override
        public boolean add(
            String CourseName, 
            String CourseNumber,
            String CourseCategory, 
            String CourseDescription) {
           
            //create a new course
            Course c = new Course();
        
            //retrieve data
            c.setCourseName(CourseName);
            c.setCourseNumber(Integer.parseInt(CourseNumber));
            c.setCourseCategory(CourseCategory);
            c.setCourseDescription(CourseDescription);
            
            //object can not already exist in database
            if(this.find(Course.class, String.valueOf(
                    c.getId())) != null) return false;
            
            //open link to db
            this.openEntityManager();
            
            //add course to database
            entitymanager.getTransaction().begin();
            entitymanager.persist( c );
            entitymanager.getTransaction( ).commit( );
            
            //close link to db
            this.closeEntityManager();
            
            //course has been sucessfully added to database 
            return true;
        }
           
        /**
        * 
        * @param <T>
	* @param cls object class to be update
        * @param id
	*/
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
}
