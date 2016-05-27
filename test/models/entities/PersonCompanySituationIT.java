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
public class PersonCompanySituationIT {
    
    public PersonCompanySituationIT() {
    }

    /**
     * Test of getPersonCompanySituationId method, of class PersonCompanySituation.
     */
    @Test
    public void testGetPersonCompanySituationId() {
        System.out.println("getPersonCompanySituationId");
        PersonCompanySituation instance = new PersonCompanySituation();
        PersonCompanySituationId expResult = null;
        PersonCompanySituationId result = instance.getPersonCompanySituationId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonCompanySituationId method, of class PersonCompanySituation.
     */
    @Test
    public void testSetPersonCompanySituationId() {
        System.out.println("setPersonCompanySituationId");
        PersonCompanySituationId personCompanySituationId = null;
        PersonCompanySituation instance = new PersonCompanySituation();
        instance.setPersonCompanySituationId(personCompanySituationId);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompany method, of class PersonCompanySituation.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        PersonCompanySituation instance = new PersonCompanySituation();
        Company expResult = null;
        Company result = instance.getCompany();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompany method, of class PersonCompanySituation.
     */
    @Test
    public void testSetCompany() {
        System.out.println("setCompany");
        Company company = null;
        PersonCompanySituation instance = new PersonCompanySituation();
        instance.setCompany(company);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerson method, of class PersonCompanySituation.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        PersonCompanySituation instance = new PersonCompanySituation();
        Person expResult = null;
        Person result = instance.getPerson();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPerson method, of class PersonCompanySituation.
     */
    @Test
    public void testSetPerson() {
        System.out.println("setPerson");
        Person person = null;
        PersonCompanySituation instance = new PersonCompanySituation();
        instance.setPerson(person);
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIndebt method, of class PersonCompanySituation.
     */
    @Test
    public void testIsIndebt() {
        System.out.println("isIndebt");
        PersonCompanySituation instance = new PersonCompanySituation();
        boolean expResult = false;
        boolean result = instance.isIndebt();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndebt method, of class PersonCompanySituation.
     */
    @Test
    public void testSetIndebt() {
        System.out.println("setIndebt");
        boolean indebt = false;
        PersonCompanySituation instance = new PersonCompanySituation();
        instance.setIndebt(indebt);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class PersonCompanySituation.
     */
    @Test
    public void testGetAll_Person() {
        System.out.println("getAll");
        Person person;
        person = Person.getAll().get(1);
        System.out.println(person.getId()+" readed");
        
        List<PersonCompanySituation> result = PersonCompanySituation.getAll(person);
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
        for(PersonCompanySituation pcsl: result){
            assertEquals(pcsl.getPerson().getId(),person.getId());
            System.out.println(pcsl.getPerson().getId()+" readed");
        }
    }

    /**
     * Test of getAll method, of class PersonCompanySituation.
     */
    @Test
    public void testGetAll_0args() {
        System.out.println("getAll");
        List<PersonCompanySituation> expResult = null;
        List<PersonCompanySituation> result = PersonCompanySituation.getAll();
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
    }
    
}
