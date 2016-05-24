/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Alisson
 */
@Entity
public class Person implements Serializable {
    @Id
    @Column(name = "PERSON_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CPF")
    private String cpf;
    
    @OneToMany(mappedBy = "person", targetEntity = PersonCompanySituation.class, cascade = CascadeType.ALL)
    private List<PersonCompanySituation> situationCompanies;
    
    //Getters and Setters

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

    public List<PersonCompanySituation> getSituationCompanies() {
        return situationCompanies;
    }

    public void setSituationCompanies(List<PersonCompanySituation> situationCompanies) {
        this.situationCompanies = situationCompanies;
    }
    
    
}
