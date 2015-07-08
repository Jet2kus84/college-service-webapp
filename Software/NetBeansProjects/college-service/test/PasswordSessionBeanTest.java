/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.depaul.djohn.entity.Password;
import edu.depaul.djohn.service.Crud;
import edu.depaul.djohn.sessionbeans.passwordbean.PasswordSessionBeanImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jet2kus84
 */
public class PasswordSessionBeanTest {
    
    public PasswordSessionBeanTest() {
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
    public void duplicatePasswordTest() {
        //create and passwords to database
        PasswordSessionBeanImpl p = new PasswordSessionBeanImpl();
        
        //create and send passwords to data again
        //this time if should pass through else
        //expection will be thrown
        PasswordSessionBeanImpl again = new PasswordSessionBeanImpl();
        System.out.println("executed without failure");
    }
    
    @Test
    public void professorSessionBeanCreationTest() {
        //create and passwords to database
        PasswordSessionBeanImpl p = new PasswordSessionBeanImpl();
        
        //remove passwords from database
        Crud.getInstance().delete(Password.class, "Professor");
        Crud.getInstance().delete(Password.class, "Advisor");
        Crud.getInstance().delete(Password.class, "Student");
        System.out.println("executed without failure");
    }
}
