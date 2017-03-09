/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb3inaction.example;

import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maggioni
 */
public class HelloUserBeanTest {
    
    public HelloUserBeanTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sayHello method, of class HelloUserBean.
     */
    @Test
    public void testSayHello() throws Exception {
        System.out.println("sayHello");
        String name = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        HelloUser instance = (HelloUser)container.getContext().lookup("java:global/classes/HelloUserBean");
        String expResult = "";
        String result = instance.sayHello(name);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
