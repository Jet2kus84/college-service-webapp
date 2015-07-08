package edu.depaul.djohn.sessionbeans.studentbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import edu.depaul.djohn.entity.Student;
import edu.depaul.djohn.sessionbeans.SessionBean;
import java.util.StringTokenizer;


@Stateful
public class StudentSessionBeanImpl extends SessionBean 
    implements StudentSessionBeanDao {

	private final List<Student> studentList;

	public StudentSessionBeanImpl() {
		studentList = new ArrayList<>();
	}

        @Override
        public boolean add(
                String firstName, 
                String lastName,
                String middleInitial,
                String dob,
                String year) {
            Student student = new Student();
        
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setMiddleInitial(middleInitial);
        
            //parse date of birth
            StringTokenizer parse = new StringTokenizer((
        		dob).replace("/", " "));
        
            student.setDateOfBirth(
        		Integer.parseInt(parse.nextToken()),
        		Integer.parseInt(parse.nextToken()), 
        		Integer.parseInt(parse.nextToken()));
        
            //student.setDateOfBirth(month, day, year);
            student.setYear(year);
        
            //set the student id
            student.setStudentID();
            this.openEntityManager();
		
            //object can not already exist in database
            if(this.find(Student.class, student.getId())
                    != null) return false;
            
            //open link to db
            this.openEntityManager();
            
            //add course to database
            entitymanager.getTransaction().begin();
            entitymanager.persist( student );
            entitymanager.getTransaction( ).commit( );

            //close link to db
            this.closeEntityManager();
            
            //student has been sucessfully added to database
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
    
    @Override //refactor update for the student class
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
			//((Student) obj).setCourseDescription("I changed something");
			entitymanager.getTransaction( ).commit( );
	      
			//after update
			System.out.println( obj );
                }
		this.closeEntityManager();
        }
}
