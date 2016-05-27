/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Person;
import models.entities.PersonCompanySituationLog;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class PersonCompanySituationLogDAO {
  public static List<PersonCompanySituationLog> readAll() {
        Session session = null;
        List<PersonCompanySituationLog> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(PersonCompanySituationLog.class).list();
        } catch (Exception e) {
            System.out.println("readAll PersonCompanySituationLog");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static List<PersonCompanySituationLog> readAll(Person person) {
        Transaction transaction = null;
        Session session = null;
        List<PersonCompanySituationLog> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonCompanySituationLog where person_id = :param");
            query.setParameter("param",person.getId());
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
