/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Alisson
 */
@Embeddable
public class DebtorCompanySituationId implements Serializable{
    @Column(name = "COMPANY_ID")
    protected Integer companyId;
    @Column(name = "DEBTOR_ID")
    protected Integer debtorId;

    public DebtorCompanySituationId() {}

    public DebtorCompanySituationId(Integer companyId, Integer debtorId) {
        this.companyId = companyId;
        this.debtorId = debtorId;
    }
   

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()== DebtorCompanySituationId.class){
            DebtorCompanySituationId objToCompare;
            objToCompare = (DebtorCompanySituationId)obj;
            if(objToCompare.getCompanyId().equals(this.companyId) && objToCompare.getDebtorId().equals(this.debtorId)){
                return true;
            }
        }
        return false;
    }
    
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(Integer debtorId) {
        this.debtorId = debtorId;
    }
    
}
