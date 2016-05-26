/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Alisson
 */
@Entity
@Table(name = "log_person_company")
public class PersonCompanySituationLog implements Serializable {

    @Id
    @Column(name = "log_person_company_id", columnDefinition ="serial")
    private Integer personCompanySituationId;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", insertable = false, updatable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false)
    private Person person;

    @Column(name = "STATUS")
    private boolean indebt;
    
    @Column(name = "LOG_DATE")
    private Date logDate;
    
    
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    
    public String getPersonName(){
        return this.getPerson().getName();
    }
    
    public String getCompanyName(){
         return this.getCompany().getName();
    }
  
    //private List<PersonCompanySituation> getAll();
    //Getter and Setters

    public Integer getPersonCompanySituationId() {
        return personCompanySituationId;
    }

    public void setPersonCompanySituationId(Integer personCompanySituationId) {
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
