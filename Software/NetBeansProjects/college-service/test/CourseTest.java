/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.depaul.djohn.entity.Course;
import edu.depaul.djohn.sessionbeans.coursebean.CourseSessionBeanDao;
import edu.depaul.djohn.sessionbeans.coursebean.CourseSessionBeanImpl;
import javax.ejb.EJB;

import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jet2kus84
 */
public class CourseTest {
   
    public CourseTest() {
    }
 
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void createNewCourseTest() {
        CourseSessionBeanDao bean = new CourseSessionBeanImpl();
        
        //create a course
        //send created course to db
        bean.add("Software Engineering Properties", "345", "SE", "This course will"
                + " act as a sample for test");
      
        //The course # act as the courseID#
        int courseID = 345;
        
        //check if course has been added to db
        Course c = bean.
                find(Course.class, String.valueOf(courseID));
        
        //delete the course added
        bean.remove(Course.class, "345");
        
        Assert.assertEquals(c.getCourseNumber(), courseID);
        
    }
    
    @Test
    public void addStudentToCourseTest() {
        
    }      
}
