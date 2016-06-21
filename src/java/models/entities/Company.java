/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import models.DAOs.CompanyDAO;

/**
 *
 *
 * @author Alisson
 */
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "COMPANY_ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TOKEN")
    private String token;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, targetEntity = DebtorCompanySituation.class, cascade = CascadeType.ALL)
    private Collection<DebtorCompanySituation> DebtorsSituation;

    public Collection<DebtorCompanySituation> getDebtorsSituation() {
        return DebtorsSituation;
    }

    public void setDebtorsSituation(Collection<DebtorCompanySituation> DebtorsSituation) {
        this.DebtorsSituation = DebtorsSituation;
    }

    public Company() {
    }

    public void add() {
        CompanyDAO.create(this);
    }

    public boolean update() {
        return CompanyDAO.update(this);
    }

    public void delete() {
        CompanyDAO.delete(this);
    }

    public static List<Company> getAll(String type, String param) {
        return CompanyDAO.readAll(type, param);
    }

    public Company getCompany() {
        if (this.id == null) {
            return CompanyDAO.readByToken(this);
        } else {
            return CompanyDAO.read(this);
        }
    }
    public Company getCompanyByToken() {
            return CompanyDAO.readByToken(this);
    }

    public static List<Company> getAll() {
        return CompanyDAO.readAll();


    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(Company.class)) {
            Company objTest = (Company) obj;
            if (objTest.getId() == this.getId()) {
                return true;
            }
        }
        return false;

    }
}
