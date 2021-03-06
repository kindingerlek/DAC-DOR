/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.io.Serializable;
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
public class Admin implements Serializable {

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

    public boolean add() {
        if (!(AdminDAO.read(this.getEmail()) == null)) {
            return AdminDAO.update(this);
        } else {
            return AdminDAO.create(this);
        }
    }

    public boolean update() {
        return AdminDAO.update(this);
    }

    public boolean delete() {
        return AdminDAO.delete(this);
    }

    public static List<Admin> getAll(String type, String param) {
        return AdminDAO.readAll(type, param);
    }

    public static List<Admin> getAll() {
        return AdminDAO.readAll();
    }

    public Admin auth() {
        Admin admin = AdminDAO.read(this.getEmail());
        if (null != admin) {
            System.out.println(admin.getId());
            System.out.println(admin.getEmail());

            if (admin.getId() == -1) {
                return admin;
            }
            if (admin.getPassword().equals(this.getPassword())) {
                return admin;
            } else {
                return null;
            }
        }
        return null;
    }

    public Admin getAdmin() {
        Admin admin = AdminDAO.read(this);
        if (admin != null) {
            return admin;
        } else {
            return null;
        }
    }
     public Admin getAdminByEmail() {
       return AdminDAO.read(this.getEmail()); 
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
