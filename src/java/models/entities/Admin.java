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
import javax.persistence.UniqueConstraint;
import models.DAOs.AdminDAO;

/**
 *
 * @author Alisson
 */
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    public Admin() {
    }

    public void add() {
        if ((AdminDAO.getUser(this.getEmail()).getId()) > 0) {
            
        } else {
            AdminDAO.add(this);
        }
    }

    public void update() {
    }

    public void delete() {
    }

    public static List<Admin> getAll(String type, String param) {

        return AdminDAO.readAll(type, param);
    }

    public Admin auth() {
        return AdminDAO.auth(this.getEmail(), this.getPassword());
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
