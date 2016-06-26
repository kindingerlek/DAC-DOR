/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.entities.Company;
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

    public static DebtorCompanySituation read(DebtorCompanySituation debSit) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            debSit = (DebtorCompanySituation) session.get(DebtorCompanySituation.class, debSit.getDebtorCompanySituationId());
            return debSit;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public static void update(DebtorCompanySituation debtorCompanySituation) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            debtorCompanySituation.setSituationDate(new Date());
            session.update(debtorCompanySituation);
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

    public static boolean saveOrUpdate(DebtorCompanySituation debtorCompanySituation) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            debtorCompanySituation.setSituationDate(new Date());
            session.saveOrUpdate(debtorCompanySituation);
            transaction = session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("SaveUpdateDebtorSituationError:" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
                return false;

            }
        } finally {
            session.close();
        }
        return true;
    }

    public static void create(DebtorCompanySituation debtorCompanySituation) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            debtorCompanySituation.setSituationDate(new Date());
            session.save(debtorCompanySituation);
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

    public static List<DebtorCompanySituation> readAll(Debtor debtor) {
        Transaction transaction = null;
        Session session = null;
        List<DebtorCompanySituation> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from DebtorCompanySituation where debtor_id = :param");
            query.setParameter("param", debtor.getId());
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

    public static void delete(DebtorCompanySituation debtorCompanySituation) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(debtorCompanySituation);
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

    public static DebtorCompanySituation read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
