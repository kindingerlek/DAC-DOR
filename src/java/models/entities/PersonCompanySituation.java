/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alisson
 */

@Entity
public class PersonCompanySituation {
    @EmbeddedId
    private PersonCompanySituationId personCompanySituationId;
    
    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name="PERSON_ID")
    private Person person;
   
    @Column(name = "STATUS")
    private boolean indebt;
      
    
    //private List<PersonCompanySituation> getAll();
    //Getter and Setters

    public PersonCompanySituationId getPersonCompanySituationId() {
        return personCompanySituationId;
    }

    public void setPersonCompanySituationId(PersonCompanySituationId personCompanySituationId) {
        this.personCompanySituationId = personCompanySituationId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isIndebt() {
        return indebt;
    }

    public void setIndebt(boolean indebt) {
        this.indebt = indebt;
    }
    
}
