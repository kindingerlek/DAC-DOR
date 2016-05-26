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
    @Column(name = "ADMIN_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL", unique = true)
    private String email;

    public Admin() {
    }

    public void add() {
        if (!(AdminDAO.read(this.getEmail()) == null)) {
            AdminDAO.update(this);
        } else {
            AdminDAO.create(this);
        }
    }

    public void update() {
        AdminDAO.update(this);
    }

    public void delete() {
        AdminDAO.delete(this);
    }

    public static List<Admin> getAll(String type, String param) {
        return AdminDAO.readAll(type, param);
    }

    public static List<Admin> getAll() {
        return AdminDAO.readAll();
    }

    public Admin auth() {
        Admin admin = AdminDAO.read(this.getEmail());
        if ( admin!=null && admin.getPassword().equals(this.getPassword())) {
            return admin;
        } else {
            return null;
        }
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
