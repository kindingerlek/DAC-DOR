/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alisson
 */
public class AdminTest {
    
    public AdminTest() {
    }

    /**
     * Test of add method, of class Admin.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Admin instance = new Admin();
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Admin.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Admin instance = new Admin();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Admin.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Admin instance = new Admin();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Admin.
     */
    @Test
    public void testGetAll_String_String() {
        System.out.println("getAll");
        String type = "name";
        String param = "Alisson";
        assertTrue("Expect result to be equal a List of Admin", Admin.getAll(type, param) instanceof List);
    }

    /**
     * Test of getAll method, of class Admin.
     */
    @Test
    public void testGetAll_0args() {
        System.out.println("getAll");
        List<Admin> expResult = null;
        List<Admin> result = Admin.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of auth method, of class Admin.
     */
    @Test
    public void testAuth() {
        System.out.println("auth");
        Admin instance = new Admin();
        Admin expResult = null;
        Admin result = instance.auth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Admin.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Admin instance = new Admin();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Admin.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Admin instance = new Admin();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Admin.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Admin.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Admin instance = new Admin();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Admin.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Admin instance = new Admin();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Admin.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Admin.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Admin instance = new Admin();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
