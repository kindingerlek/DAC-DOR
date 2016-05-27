/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Person;
import models.entities.PersonCompanySituation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class PersonCompanySituationDAO {

   

    public static void update(PersonCompanySituation personCompanySituation) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(personCompanySituation);
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

    public static void create(PersonCompanySituation personCompanySituation) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(personCompanySituation);
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

    public static List<PersonCompanySituation> readAll() {
        Session session = null;
        List<PersonCompanySituation> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(PersonCompanySituation.class).list();
        } catch (Exception e) {
            System.out.println("readAll PersonCompanySituation");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static List<PersonCompanySituation> readAll(Person person) {
        Transaction transaction = null;
        Session session = null;
        List<PersonCompanySituation> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonCompanySituation where person_id = :param");
            query.setParameter("param", person.getId());
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
    

    public static void readPersonCompanySituation() {
    }

    public static void delete(PersonCompanySituation personCompanySituation) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(personCompanySituation);
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
