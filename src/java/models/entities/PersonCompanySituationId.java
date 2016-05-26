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
public class PersonCompanySituationId implements Serializable{
    @Column(name = "COMPANY_ID")
    protected Integer companyId;
    @Column(name = "PERSON_ID")
    protected Integer personId;

    public PersonCompanySituationId() {}

    public PersonCompanySituationId(Integer companyId, Integer personId) {
        this.companyId = companyId;
        this.personId = personId;
    }
   

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()== PersonCompanySituationId.class){
            PersonCompanySituationId objToCompare;
            objToCompare = (PersonCompanySituationId)obj;
            if(objToCompare.getCompanyId().equals(this.companyId) && objToCompare.getPersonId().equals(this.personId)){
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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    
}
