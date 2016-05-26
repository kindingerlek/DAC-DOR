/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Company;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class CompanyDAO {

    public static boolean validateToken(Company company) {
        Transaction transaction = null;
        Session session = null;
        Company companyReturned = null;
        try {
            session = getSessionFactory().openSession();
            String token = company.getToken();
            company.setToken(token);
            Query query = session.createQuery("from Company where token = :token");
            query.setParameter("token", company.getToken());
            
            companyReturned = (Company) query.uniqueResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return (companyReturned != null);
    }

    public static void update(Company company) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(company);
            transaction = session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }

    public static void create(Company company) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(company);
            transaction = session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }

    public static List<Company> readAll() {
        Session session = null;
        List<Company> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(Company.class).list();
        } catch (Exception e) {
            System.out.println("readAll Company");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Company> readAll(String type, String param) {
        Transaction transaction = null;
        Session session = null;
        List<Company> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from Company where " + type + " like :param");
            query.setParameter("param", "%" + param + "%");
            list = query.list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return list;
    }
        
    public static void delete(Company company) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(company);
            transaction = session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }
}
