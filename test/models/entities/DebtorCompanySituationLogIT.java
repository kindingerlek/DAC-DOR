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
public class DebtorCompanySituationLogIT {
    
    public DebtorCompanySituationLogIT() {
    }

    /**
     * Test of getLogDate method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testGetLogDate() {
        System.out.println("get and set logDate");
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        Date expResult = new Date();
        instance.setLogDate(expResult);
        Date result = instance.getLogDate();
        assertEquals(expResult, result);
        
    }

 

    /**
     * Test of getDebtorName method, of class DebtorCompanySituationLog.
     */
   

    /**
     * Test of getDebtorCompanySituationLogId method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testGetDebtorCompanySituationLogId() {
        System.out.println("getDebtorCompanySituationLogId");
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        Integer expResult = null;
        Integer result = instance.getDebtorCompanySituationLogId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDebtorCompanySituationLogId method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testSetDebtorCompanySituationLogId() {
        System.out.println("setDebtorCompanySituationLogId");
        Integer debtorCompanySituationId = null;
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        instance.setDebtorCompanySituationLogId(debtorCompanySituationId);
        
    }

    /**
     * Test of getCompany method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        Company expResult = null;
        Company result = instance.getCompany();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCompany method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testSetCompany() {
        System.out.println("setCompany");
        Company company = null;
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        instance.setCompany(company);
        
    }

    /**
     * Test of getDebtor method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testGetDebtor() {
        System.out.println("getDebtor");
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        Debtor expResult = null;
        Debtor result = instance.getDebtor();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDebtor method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testSetDebtor() {
        System.out.println("setDebtor");
        Debtor debtor = null;
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        instance.setDebtor(debtor);
        
    }

    /**
     * Test of isIndebt method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testIsIndebt() {
        System.out.println("isIndebt");
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        boolean expResult = false;
        boolean result = instance.isIndebt();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIndebt method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testSetIndebt() {
        System.out.println("setIndebt");
        boolean indebt = false;
        DebtorCompanySituationLog instance = new DebtorCompanySituationLog();
        instance.setIndebt(indebt);
        
    }

    /**
     * Test of getAll method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testGetAll_String_String() {
        System.out.println("getAll");
        Debtor debtor = new Debtor();
        debtor = debtor.getAll().get(1);
        System.out.println(debtor.getId()+" readed");
        
        List<DebtorCompanySituationLog> result = DebtorCompanySituationLog.getAll(debtor);
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
        for(DebtorCompanySituationLog pcsl: result){
            assertEquals(pcsl.getDebtor().getId(),debtor.getId());
            System.out.println(pcsl.getDebtor().getId()+" readed");
        }
        
    }

    /**
     * Test of getAll method, of class DebtorCompanySituationLog.
     */
    @Test
    public void testGetAll_0args() {
        System.out.println("getAll");
        List<DebtorCompanySituationLog> expResult = null;
        List<DebtorCompanySituationLog> result = DebtorCompanySituationLog.getAll();
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
    }
    
    @Test
    public void testReadActualSituation() {
        System.out.println("getAll");
        Debtor debtor = new Debtor();
        debtor = debtor.getAll().get(1);
        System.out.println(debtor.getId()+" readed");
        
        List<DebtorCompanySituationLog> result = DebtorCompanySituationLog.getActualSituation(debtor);
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
        for(DebtorCompanySituationLog pcsl: result){
            assertEquals(pcsl.getDebtor().getId(),debtor.getId());
            System.out.println(pcsl.getDebtor().getId()+" readed");
        }
        
    }
}
