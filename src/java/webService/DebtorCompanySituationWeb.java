/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import java.io.Serializable;

/**
 *
 * @author Alisson
 */
public class DebtorCompanySituationWeb implements Serializable{
    private String debtorIdentifier;
    private String companyToken;
    private boolean indebt;

    public String getDebtorIdentifier() {
        return debtorIdentifier;
    }

    public void setDebtorIdentifier(String debtorIdentifier) {
        this.debtorIdentifier = debtorIdentifier;
    }

    public String getCompanyToken() {
        return companyToken;
    }

    public void setCompanyToken(String companyToken) {
        this.companyToken = companyToken;
    }

    public boolean isIndebt() {
        return indebt;
    }

    public void setIndebt(boolean indebt) {
        this.indebt = indebt;
    }
    
}
