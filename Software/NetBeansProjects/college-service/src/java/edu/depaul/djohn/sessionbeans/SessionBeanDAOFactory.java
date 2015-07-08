
package edu.depaul.djohn.sessionbeans;

import edu.depaul.djohn.sessionbeans.advisorbean.AdvisorSessionBeanDao;
import edu.depaul.djohn.sessionbeans.advisorbean.AdvisorSessionBeanImpl;
import edu.depaul.djohn.sessionbeans.coursebean.CourseSessionBeanDao;
import edu.depaul.djohn.sessionbeans.coursebean.CourseSessionBeanImpl;
import edu.depaul.djohn.sessionbeans.passwordbean.PasswordSessionBeanDao;
import edu.depaul.djohn.sessionbeans.passwordbean.PasswordSessionBeanImpl;
import edu.depaul.djohn.sessionbeans.professorbean.ProfessorSessionBeanDao;
import edu.depaul.djohn.sessionbeans.professorbean.ProfessorSessionBeanImpl;
import edu.depaul.djohn.sessionbeans.studentbean.StudentSessionBeanDao;
import edu.depaul.djohn.sessionbeans.studentbean.StudentSessionBeanImpl;

/**
 *
 * @author Deonte Johnson
 * 
 * This class will be used to gain access to the 
 * data objects
 */
public class SessionBeanDAOFactory {
    
    public CourseSessionBeanDao getCourseSessionBeanDao() {
        return new CourseSessionBeanImpl();
    }
    
    public StudentSessionBeanDao getStudentSessionBeanDao() {
        return new StudentSessionBeanImpl();
    }
    
    public AdvisorSessionBeanDao getAdvisorSessionBeanDao() {
        return new AdvisorSessionBeanImpl();
    }
    
    public ProfessorSessionBeanDao getProfessorSessionBeanDao() {
        return new ProfessorSessionBeanImpl();
    }
    
    public PasswordSessionBeanDao getPasswordSessionBeanDao() {
        return new PasswordSessionBeanImpl();
    }
}
