/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.io.Serializable;
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

import models.DAOs.DebtorDAO;

/**
 *
 * @author Alisson
 */
@Entity
public class Debtor implements Serializable {
    
    @Id
    @GeneratedValue                                                                                                                                                                                                                                                                            
    @Column(name = "DEBTOR_ID")
    private Integer id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "IDENTIFIER")
    private String identifier;
    
    @OneToMany(mappedBy = "debtor", fetch = FetchType.LAZY, targetEntity = DebtorCompanySituation.class, cascade ={ CascadeType.ALL})
    private Collection<DebtorCompanySituation> situationCompanies = new LinkedHashSet<DebtorCompanySituation>();
    
    //Getters and Setters
    public void add(){
        DebtorDAO.create(this);
    }
    
    public void update(){
        DebtorDAO.update(this);
    }
    
    public static Collection<Debtor> getAll(String type, String pattern){
        return DebtorDAO.readAll(type, pattern);
    }
   
    public void createOrReplace(){
        if(DebtorDAO.readDebtor(this)!=null){
            DebtorDAO.create(this);
        }else{
            DebtorDAO.update(this);
        }
    }
    
    public Debtor getDebtor(){
          if (this.id == null) {
            return DebtorDAO.readDebtor(this);
        } else {
        return DebtorDAO.read(this);
          }
    }
    
    
   public boolean getIndebted(){
        return DebtorDAO.isIndebted(this);
   }
   
    public boolean isIndebted(){
        return DebtorDAO.isIndebted(this);
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Collection<DebtorCompanySituation> getSituationCompanies() {
        return situationCompanies;
    }

    public void setSituationCompanies(List<DebtorCompanySituation> situationCompanies) {
        this.situationCompanies = situationCompanies;
    }

    public static List<Debtor> getAll() {
        return DebtorDAO.readAll();
    }

}
