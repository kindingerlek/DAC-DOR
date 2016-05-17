/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import models.DAOs.CompanyDAO;

/**
 *
 *
 * @author Alisson
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "token")
    private String token;

    public Company() {
    }

    public void add() {
        CompanyDAO.create(this);
    }

    public void update() {
        CompanyDAO.update(this);
    }

    public void delete() {
        CompanyDAO.delete(this);
    }

    public static List<Company> getAll(String type, String param) {
        return CompanyDAO.readAll(type, param);
    }

    public static List<Company> getAll() {
        return CompanyDAO.readAll();
    }

    public boolean validateToken() {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
