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
import models.DAOs.PersonDAO;

/**
 *
 * @author Alisson
 */
@Entity
public class Person implements Serializable {
    
    @Id
    @GeneratedValue                                                                                                                                                                                                                                                                            
    @Column(name = "PERSON_ID")
    private int id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CPF")
    private String cpf;
    
    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY, targetEntity = PersonCompanySituation.class, cascade = CascadeType.ALL)
    private Collection<PersonCompanySituation> situationCompanies = new LinkedHashSet<PersonCompanySituation>();
    
    //Getters and Setters
    public void add(){
        PersonDAO.create(this);
    }
    
    public void update(){
        PersonDAO.update(this);
    }
    
    public static Collection<Person> getAll(String type, String pattern){
        return PersonDAO.readAll(type, pattern);
    }
   
    public void createOrReplace(){
        if(PersonDAO.readPerson(this)!=null){
            PersonDAO.create(this);
        }else{
            PersonDAO.update(this);
        }
    }
    
    
    //TODO THIOS METHOD HUEHUEHUEHUEHUE
    public boolean isIndebted(){
        return false;
    }
    
    public int getId() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Collection<PersonCompanySituation> getSituationCompanies() {
        return situationCompanies;
    }

    public void setSituationCompanies(List<PersonCompanySituation> situationCompanies) {
        this.situationCompanies = situationCompanies;
    }

    public static List<Person> getAll() {
        return PersonDAO.readAll();
    }

}
