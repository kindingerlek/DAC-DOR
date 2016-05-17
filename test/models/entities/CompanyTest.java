/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alisson
 */
public class CompanyTest {

    public CompanyTest() {
    }

    /**
     * Test of add method, of class Company.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Company instance = new Company();
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Company.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Company instance = new Company();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Company.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Company instance = new Company();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Company.
     */
    @Test
    public void testGetAll_String_String() {
        System.out.println("getAll");
        String type = "name";
        String param = "2w";
        assertTrue("Expect result to be equal a List of Company", Company.getAll(type, param) instanceof List);
    }

    /**
     * Test of getAll method, of class Company.
     */
    @Test
    public void testGetAll_0args() {
        System.out.println("getAll");
        Company instance = new Company();
        List<Company> expResult = null;
        List<Company> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateToken method, of class Company.
     */
    @Test
    public void testValidateToken() {
        System.out.println("validateToken");
        Company instance = new Company();
        boolean expResult = false;
        boolean result = instance.validateToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Company.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Company instance = new Company();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Company.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Company instance = new Company();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Company.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Company instance = new Company();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Company.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Company instance = new Company();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToken method, of class Company.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        Company instance = new Company();
        String expResult = "";
        String result = instance.getToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToken method, of class Company.
     */
    @Test
    public void testSetToken() {
        System.out.println("setToken");
        String token = "";
        Company instance = new Company();
        instance.setToken(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
