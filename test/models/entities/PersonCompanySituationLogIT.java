/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alisson
 */
public class PersonCompanySituationLogIT {
    
    public PersonCompanySituationLogIT() {
    }

    /**
     * Test of getLogDate method, of class PersonCompanySituationLog.
     */
    @Test
    public void testGetLogDate() {
        System.out.println("get and set logDate");
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        Date expResult = new Date();
        instance.setLogDate(expResult);
        Date result = instance.getLogDate();
        assertEquals(expResult, result);
        
    }

 

    /**
     * Test of getPersonName method, of class PersonCompanySituationLog.
     */
   

    /**
     * Test of getPersonCompanySituationLogId method, of class PersonCompanySituationLog.
     */
    @Test
    public void testGetPersonCompanySituationLogId() {
        System.out.println("getPersonCompanySituationLogId");
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        Integer expResult = null;
        Integer result = instance.getPersonCompanySituationLogId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPersonCompanySituationLogId method, of class PersonCompanySituationLog.
     */
    @Test
    public void testSetPersonCompanySituationLogId() {
        System.out.println("setPersonCompanySituationLogId");
        Integer personCompanySituationId = null;
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        instance.setPersonCompanySituationLogId(personCompanySituationId);
        
    }

    /**
     * Test of getCompany method, of class PersonCompanySituationLog.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        Company expResult = null;
        Company result = instance.getCompany();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCompany method, of class PersonCompanySituationLog.
     */
    @Test
    public void testSetCompany() {
        System.out.println("setCompany");
        Company company = null;
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        instance.setCompany(company);
        
    }

    /**
     * Test of getPerson method, of class PersonCompanySituationLog.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        Person expResult = null;
        Person result = instance.getPerson();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPerson method, of class PersonCompanySituationLog.
     */
    @Test
    public void testSetPerson() {
        System.out.println("setPerson");
        Person person = null;
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        instance.setPerson(person);
        
    }

    /**
     * Test of isIndebt method, of class PersonCompanySituationLog.
     */
    @Test
    public void testIsIndebt() {
        System.out.println("isIndebt");
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        boolean expResult = false;
        boolean result = instance.isIndebt();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIndebt method, of class PersonCompanySituationLog.
     */
    @Test
    public void testSetIndebt() {
        System.out.println("setIndebt");
        boolean indebt = false;
        PersonCompanySituationLog instance = new PersonCompanySituationLog();
        instance.setIndebt(indebt);
        
    }

    /**
     * Test of getAll method, of class PersonCompanySituationLog.
     */
    @Test
    public void testGetAll_String_String() {
        System.out.println("getAll");
        Person person = new Person();
        person = person.getAll().get(1);
        System.out.println(person.getId()+" readed");
        
        List<PersonCompanySituationLog> result = PersonCompanySituationLog.getAll(person);
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
        for(PersonCompanySituationLog pcsl: result){
            assertEquals(pcsl.getPerson().getId(),person.getId());
            System.out.println(pcsl.getPerson().getId()+" readed");
        }
        
    }

    /**
     * Test of getAll method, of class PersonCompanySituationLog.
     */
    @Test
    public void testGetAll_0args() {
        System.out.println("getAll");
        List<PersonCompanySituationLog> expResult = null;
        List<PersonCompanySituationLog> result = PersonCompanySituationLog.getAll();
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
    }
}
