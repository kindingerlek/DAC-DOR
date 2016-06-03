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
import javax.persistence.Table;
import models.DAOs.DebtorCompanySituationDAO;

/**
 *
 * @author Alisson
 */

@Entity
@Table(name = "debtor_company_situation")
public class DebtorCompanySituation {
    @EmbeddedId
    private DebtorCompanySituationId debtorCompanySituationId;
    
    @ManyToOne
    @JoinColumn(name="COMPANY_ID",insertable=false, updatable=false)
    private Company company;
    
    @ManyToOne
    @JoinColumn(name="DEBTOR_ID",insertable=false, updatable=false)
    private Debtor debtor;
   
    @Column(name = "STATUS")
    private boolean indebt;
      
    
    //private List<DebtorCompanySituation> getAll();
    //Getter and Setters

    public DebtorCompanySituationId getDebtorCompanySituationId() {
        return debtorCompanySituationId;
    }

    public void setDebtorCompanySituationId(DebtorCompanySituationId debtorCompanySituationId) {
        this.debtorCompanySituationId = debtorCompanySituationId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }

    public boolean isIndebt() {
        return indebt;
    }

    public void setIndebt(boolean indebt) {
        this.indebt = indebt;
    }
    
    public static List<DebtorCompanySituation> getAll(Debtor debtor) {
        return DebtorCompanySituationDAO.readAll(debtor);
    }

    public static List<DebtorCompanySituation> getAll() {
        return DebtorCompanySituationDAO.readAll();
    }
    
}
