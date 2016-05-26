/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class AdminDAO {


    public static Admin read(String email) {
        Session session = getSessionFactory().openSession();
        Admin admin = new Admin();
        admin.setEmail(email);
        Query query = session.createQuery("from Admin where email = :email");
        query.setParameter("email", admin.getEmail());
        admin = (Admin) query.uniqueResult();
        session.close();
        return admin;
    }
    
    public static void update(Admin admin){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(admin);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void create(Admin admin) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<Admin> readAll(){
        Session session = getSessionFactory().openSession();
        List<Admin> list = session.createCriteria(Admin.class).list();
        session.close();
        return list;
    }
    
    public static List<Admin> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Admin where "+type+" like :param");
        query.setParameter("param", "%"+param+"%");
        List<Admin> list = query.list();
        session.close();
        return list;
    }
    
    public static void delete(Admin admin){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(admin);
        session.getTransaction().commit();
        session.close();
    }
}
