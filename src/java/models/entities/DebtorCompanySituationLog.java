/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import models.DAOs.DebtorCompanySituationLogDAO;

/**
 *
 * @author Alisson
 */
@Entity
@Table(name = "log_debtor_company_situation")
public class DebtorCompanySituationLog implements Serializable {

    @Id
    @Column(name = "log_debtor_company_id", columnDefinition = "serial")
    private Integer debtorCompanySituationId;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", insertable = false, updatable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "DEBTOR_ID", insertable = false, updatable = false)
    private Debtor debtor;

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

    public String getDebtorName() {
        return this.getDebtor().getName();
    }

    public String getCompanyName() {
        return this.getCompany().getName();
    }

    //private List<DebtorCompanySituationLog> getAll();
    //Getter and Setters
    public Integer getDebtorCompanySituationLogId() {
        return debtorCompanySituationId;
    }

    public void setDebtorCompanySituationLogId(Integer debtorCompanySituationId) {
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

    public static List<DebtorCompanySituationLog> getAll(Debtor debtor) {
        return DebtorCompanySituationLogDAO.readAll(debtor);
    }
    
    public static List<DebtorCompanySituationLog> getActualSituation(Debtor debtor) {
        return DebtorCompanySituationLogDAO.readActualSituation(debtor);
    }

    public static List<DebtorCompanySituationLog> getAll() {
        return DebtorCompanySituationLogDAO.readAll();
    }
}
