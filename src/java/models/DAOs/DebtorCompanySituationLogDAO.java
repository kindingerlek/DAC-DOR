/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Debtor;
import models.entities.DebtorCompanySituationLog;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class DebtorCompanySituationLogDAO {
  public static List<DebtorCompanySituationLog> readAll() {
        Session session = null;
        List<DebtorCompanySituationLog> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(DebtorCompanySituationLog.class).list();
        } catch (Exception e) {
            System.out.println("readAll DebtorCompanySituationLog");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static List<DebtorCompanySituationLog> readAll(Debtor debtor) {
        Transaction transaction = null;
        Session session = null;
        List<DebtorCompanySituationLog> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
             Criteria crit = session.createCriteria(DebtorCompanySituationLog.class);
            crit.add(Restrictions.eq("debtor",debtor));
            crit.addOrder(Order.desc("logDate"));
            
            list = crit.list();
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
    
     public static List<DebtorCompanySituationLog> readActualSituation(Debtor debtor) {
        Transaction transaction = null;
        Session session = null;
        List<DebtorCompanySituationLog> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("DISTINCT ON (Company_Id) from DebtorCompanySituationLog  where debtor_id = :param ORDER  BY company_id, log_date desc");
            query.setParameter("param",debtor.getId());
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
}
