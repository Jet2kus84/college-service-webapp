/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.depaul.djohn.entity.Password;
import edu.depaul.djohn.service.Crud;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Deonte Johnson
 */
public class PasswordBeanTest {
    
    public PasswordBeanTest() {
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
    public void passwordCreationsTest() {
        Password pwd = new Password();
        pwd.setType("JOHNSON");
        pwd.setUsername("wacky103");
        pwd.setPassword("student2015");
        
        Crud.getInstance().create(pwd);
        Crud.getInstance().delete(Password.class, "JOHNSON");
    }
}
