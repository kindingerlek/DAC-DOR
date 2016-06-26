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
        Session session = null;
        Admin admin = new Admin();
        admin.setEmail(email);
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from Admin where email = :email");
            query.setParameter("email", admin.getEmail());
            admin = (Admin) query.uniqueResult();
        } catch (Exception ex) {
            admin.setId(-1);
            System.out.println(ex.getMessage());
            return admin;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return admin;
    }

    public static Admin read(Admin admin) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            admin = (Admin) session.get(Admin.class, admin.getId());

            return admin;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public static boolean update(Admin admin) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(admin);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean create(Admin admin) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(admin);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public static List<Admin> readAll() {
        Session session = getSessionFactory().openSession();
        List<Admin> list = session.createCriteria(Admin.class).list();
        session.close();
        return list;
    }

    public static List<Admin> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Admin where " + type + " like :param");
        query.setParameter("param", "%" + param + "%");
        List<Admin> list = query.list();
        session.close();
        return list;
    }

    public static boolean delete(Admin admin) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(admin);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Admin Delete Error");
            System.out.println(ex.getMessage());
            return false;
        } finally {
            if (null !=session) {
                session.close();
            }
        }
        return true;
    }
}
