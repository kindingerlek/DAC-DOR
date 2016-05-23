/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.List;
import models.entities.Company;
import org.hibernate.Query;
import org.hibernate.Session;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class CompanyDAO {
   
      public static boolean validateToken(Company company) {
        Session session = getSessionFactory().openSession();
        String token = company.getToken();
        company.setToken(token);
        Query query = session.createQuery("from Company where token = :token");
        query.setParameter("token", company.getToken());
        Company companyReturned;
        companyReturned = (Company) query.uniqueResult();
        session.close();
        return (companyReturned!=null);
    }
      
    public static void update(Company company){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(company);
        session.getTransaction().commit();
        session.close();
    }
    public static void create(Company company) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<Company> readAll(){
        Session session = getSessionFactory().openSession();
        List<Company> list = session.createCriteria(Company.class).list();
        session.close();
        return list;
    }
     public static List<Company> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Company where "+type+" like :param");
        query.setParameter("param", "%"+param+"%");
        List<Company> list = query.list();
        session.close();
        return list;
    }
    
    public static void readCompany(){
    }
    public static void delete(Company company){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(company);
        session.getTransaction().commit();
        session.close();
    } 
}
