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
public class DebtorCompanySituationIT {
    
    public DebtorCompanySituationIT() {
    }

    /**
     * Test of getDebtorCompanySituationId method, of class DebtorCompanySituation.
     */
    @Test
    public void testGetDebtorCompanySituationId() {
        System.out.println("getDebtorCompanySituationId");
        DebtorCompanySituation instance = new DebtorCompanySituation();
        DebtorCompanySituationId expResult = null;
        DebtorCompanySituationId result = instance.getDebtorCompanySituationId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebtorCompanySituationId method, of class DebtorCompanySituation.
     */
    @Test
    public void testSetDebtorCompanySituationId() {
        System.out.println("setDebtorCompanySituationId");
        DebtorCompanySituationId debtorCompanySituationId = null;
        DebtorCompanySituation instance = new DebtorCompanySituation();
        instance.setDebtorCompanySituationId(debtorCompanySituationId);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompany method, of class DebtorCompanySituation.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        DebtorCompanySituation instance = new DebtorCompanySituation();
        Company expResult = null;
        Company result = instance.getCompany();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompany method, of class DebtorCompanySituation.
     */
    @Test
    public void testSetCompany() {
        System.out.println("setCompany");
        Company company = null;
        DebtorCompanySituation instance = new DebtorCompanySituation();
        instance.setCompany(company);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebtor method, of class DebtorCompanySituation.
     */
    @Test
    public void testGetDebtor() {
        System.out.println("getDebtor");
        DebtorCompanySituation instance = new DebtorCompanySituation();
        Debtor expResult = null;
        Debtor result = instance.getDebtor();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebtor method, of class DebtorCompanySituation.
     */
    @Test
    public void testSetDebtor() {
        System.out.println("setDebtor");
        Debtor debtor = null;
        DebtorCompanySituation instance = new DebtorCompanySituation();
        instance.setDebtor(debtor);
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIndebt method, of class DebtorCompanySituation.
     */
    @Test
    public void testIsIndebt() {
        System.out.println("isIndebt");
        DebtorCompanySituation instance = new DebtorCompanySituation();
        boolean expResult = false;
        boolean result = instance.isIndebt();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndebt method, of class DebtorCompanySituation.
     */
    @Test
    public void testSetIndebt() {
        System.out.println("setIndebt");
        boolean indebt = false;
        DebtorCompanySituation instance = new DebtorCompanySituation();
        instance.setIndebt(indebt);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class DebtorCompanySituation.
     */
    @Test
    public void testGetAll_Debtor() {
        System.out.println("getAll");
        Debtor debtor;
        debtor = Debtor.getAll().get(1);
        System.out.println(debtor.getId()+" readed");
        
        List<DebtorCompanySituation> result = DebtorCompanySituation.getAll(debtor);
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
        for(DebtorCompanySituation pcsl: result){
            assertEquals(pcsl.getDebtor().getId(),debtor.getId());
            System.out.println(pcsl.getDebtor().getId()+" readed");
        }
    }

    /**
     * Test of getAll method, of class DebtorCompanySituation.
     */
    @Test
    public void testGetAll_0args() {
        System.out.println("getAll");
        List<DebtorCompanySituation> expResult = null;
        List<DebtorCompanySituation> result = DebtorCompanySituation.getAll();
        if(result.isEmpty()){
            fail("this should be get a filled list");
        }
    }
    
}
