/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class PersonDAO {

   

    public static void update(Person person) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(person);
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

    public static void create(Person person) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
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

    public static List<Person> readAll() {
        Session session = null;
        List<Person> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(Person.class).list();
        } catch (Exception e) {
            System.out.println("readAll Person");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Person> readAll(String type, String param) {
        Transaction transaction = null;
        Session session = null;
        List<Person> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from Person where " + type + " like :param");
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
    public static Person readPerson(Person person){
        Transaction transaction = null;
        Session session = null;
        Person personReturned = null;
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from Person where cpf= :param");
            query.setParameter("param", person.getCpf());
            personReturned = (Person) query.uniqueResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return personReturned;  
    }

    
    public static void delete(Person person) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(person);
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
