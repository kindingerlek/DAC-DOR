/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.List;
import models.DAOs.CompanyDAO;
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
        instance.setName("testCompanyNotUseThisName");
        instance.setToken("testTokenNotUseThisName");
        instance.add();
        instance = CompanyDAO.readAll("name", "testCompanyNotUseThisName").get(0);
        assertNotNull("Should return a company", instance);

        // TODO review the generated test code and remove the default call to fail.
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
        assertTrue("Expect result to be equal a List of Company", Company.getAll() instanceof List);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of update method, of class Company.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Company instance = new Company();
        String newToken = "TokenChangedToTestUpdateMethod";
        instance = CompanyDAO.readAll("name", "testCompanyUpdateNotUseThisName").get(0);
        instance.setToken(newToken);
        instance.update();
        Company companyUpdated = CompanyDAO.readAll("name", "testCompanyUpdateNotUseThisName").get(0);
        assertEquals("token should be changed to 'TokenChangedToTestUpdateMethod'",companyUpdated.getToken(),newToken);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of delete method, of class Company.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Company instance = new Company();
        instance = CompanyDAO.readAll("name", "testCompanyNotUseThisName").get(0);
        instance.delete();
         
        assertTrue("Should not return any company", CompanyDAO.readAll("name", "testCompanyNotUseThisName").isEmpty());
    }

    /**
     * Test of getId method, of class Company.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Company instance = new Company();
        int expResult = 0;
        instance.setId(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class Company.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 0;
        Company instance = new Company();
        instance.setId(id);
        assertEquals(instance.getId(),id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class Company.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Company instance = new Company();
        String expResult = "";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setName method, of class Company.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "testNameToCompany";
        Company instance = new Company();
        instance.setName(name);
        assertEquals(instance.getName(),name);
        
    }

    /**
     * Test of getToken method, of class Company.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        Company instance = new Company();
        String expResult = "testTokenToValidateThisCompanyMethod";
        instance.setToken(expResult);
        String result = instance.getToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setToken method, of class Company.
     */
    @Test
    public void testSetToken() {
        System.out.println("setToken");
        String token = "testTokenToValidadeThisMetohd";
        Company instance = new Company();
        instance.setToken(token);
        assertEquals(instance.getToken(),token);
        // TODO review the generated test code and remove the default call to fail.
    }

}
