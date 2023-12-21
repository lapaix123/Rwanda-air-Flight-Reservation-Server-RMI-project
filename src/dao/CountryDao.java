/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author la paix
 */
public class CountryDao {
     public String createCountry(Country country) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(country);
            transaction.commit();
            session.close();
            return "Country Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating Country: " + e.getMessage();
        }
    }

    public String updateCountry(Country country) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(country);
            transaction.commit();
            session.close();
            return "Country Updated Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating Country: " + e.getMessage();
        }
    }

    public String deleteCountry(Country country) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(country);
            transaction.commit();
            session.close();
            return "Country Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting Country: " + e.getMessage();
        }
    }

    public List<Country> getAllCountries() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Country> countries = session.createQuery("select country FROM Country country").list();
            session.close();
            return countries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Country findCountryById(Country country) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Country country1 =(Country) session.get(Country.class, country.getCountryId());
            session.close();
            return country1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
