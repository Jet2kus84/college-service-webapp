/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.depaul.djohn.entity.Professor;
import edu.depaul.djohn.sessionbeans.professorbean.ProfessorSessionBeanDao;
import edu.depaul.djohn.sessionbeans.professorbean.ProfessorSessionBeanImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jet2kus84
 */
public class ProfessorBeanTest {
    
    public ProfessorBeanTest() {
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
    public void professorCreationTest() {
        ProfessorSessionBeanDao bean = new ProfessorSessionBeanImpl();
        
        bean.add("James", "Walker", 1223);
        System.out.println("add successfully");
        bean.remove(Professor.class, "1223");
        System.out.println("removed successfully");
    }
}
