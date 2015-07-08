/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.depaul.djohn.entity.Advisor;
import edu.depaul.djohn.sessionbeans.advisorbean.AdvisorSessionBeanDao;
import edu.depaul.djohn.sessionbeans.advisorbean.AdvisorSessionBeanImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jet2kus84
 */
public class AdvisorBeanTest {
    
    public AdvisorBeanTest() {
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
    public void advisorCreationTest() {
        AdvisorSessionBeanDao bean = new AdvisorSessionBeanImpl();
        
        bean.add("John", "Jameson", 25);
        System.out.println("successfully added");
        bean.remove(Advisor.class, "25");
        System.out.println("successfully removed");
    }
}
