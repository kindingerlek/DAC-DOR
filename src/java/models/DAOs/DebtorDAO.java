/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Debtor;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class DebtorDAO {

    public static Debtor read(Debtor debtor) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            debtor = (Debtor) session.get(Debtor.class,debtor.getId());
            debtor.getSituationCompanies().size();
            
            return debtor;
        } catch (Exception e) {
                throw e;
        } finally {
            session.close();
        }  
    }

    public static void update(Debtor debtor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(debtor);
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

    public static void create(Debtor debtor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(debtor);
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

    public static List<Debtor> readAll() {
        Session session = null;
        List<Debtor> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(Debtor.class).list();
        } catch (Exception e) {
          
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Debtor> readAll(String type, String param) {
        Transaction transaction = null;
        Session session = null;
        List<Debtor> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from Debtor where " + type + " like :param");
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

    public static Debtor readDebtor(Debtor debtor) {
        Transaction transaction = null;
        Session session = null;
        Debtor debtorReturned = null;
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from Debtor where cpf= :param");
            query.setParameter("param", debtor.getIdentifier());
            debtorReturned = (Debtor) query.uniqueResult();
        } catch (Exception e) {
            
        } finally {
            session.close();
        }
        return debtorReturned;
    }

    public static void delete(Debtor debtor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(debtor);
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
