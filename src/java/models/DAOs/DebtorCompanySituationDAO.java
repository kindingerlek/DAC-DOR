/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Debtor;
import models.entities.DebtorCompanySituation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class DebtorCompanySituationDAO {

   

    public static void update(DebtorCompanySituation personCompanySituation) {
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

    public static void create(DebtorCompanySituation personCompanySituation) {
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

    public static List<DebtorCompanySituation> readAll() {
        Session session = null;
        List<DebtorCompanySituation> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(DebtorCompanySituation.class).list();
        } catch (Exception e) {
            System.out.println("readAll DebtorCompanySituation");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static List<DebtorCompanySituation> readAll(Debtor person) {
        Transaction transaction = null;
        Session session = null;
        List<DebtorCompanySituation> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from DebtorCompanySituation where person_id = :param");
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
    

    public static void readDebtorCompanySituation() {
    }

    public static void delete(DebtorCompanySituation personCompanySituation) {
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
