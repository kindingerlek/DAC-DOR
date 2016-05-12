/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import models.DAOs.AdminDAO;

/**
 *
 * @author Alisson
 */
@Entity
public class Admin {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String password;
    private String email;

    public Admin() {
    }

    public void add() {
    }

    public void update() {
    }

    public void delete() {
    }

    public static List<Admin> getAll(String type, String param) {

        return AdminDAO.readAll(type, param);
    }

    public Admin auth() {
        return AdminDAO.auth(this.getEmail(),this.getPassword());
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
