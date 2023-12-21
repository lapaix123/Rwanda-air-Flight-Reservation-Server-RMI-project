/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Airline;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author la paix
 */
public class AirlineDao {
    public String newAirline(Airline airline){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.save(airline);
            tr.commit();
            ss.close();
            return "new Airline Create Sucessfull";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      public String updateAirline(Airline airline){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.update(airline);
            tr.commit();
            ss.close();
            return "new Airline Create Sucessfull";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      public String deleteAirline(Airline airline){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.delete(airline);
            tr.commit();
            ss.close();
            return "new Airline Create Sucessfull";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      
       public List<Airline> airlineListe(){
           try {
               Session ss=HibernateUtil.getSessionFactory().openSession();
               List<Airline> airlines=ss.createQuery("select airline from Airline airline").list();
               ss.close();
               return airlines;
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           }
       }
       
        public Airline findById(Airline airline){
           try {
                Session ss = HibernateUtil.getSessionFactory().openSession();
               Airline airline1 = (Airline)ss.get(Airline.class, airline.getAirlineId());
               ss.close();
               return airline1;
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           }
       }
    
}
