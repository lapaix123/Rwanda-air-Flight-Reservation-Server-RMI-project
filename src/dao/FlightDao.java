/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.Flight;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author la paix
 */
public class FlightDao {
     public String createFlight(Flight flight) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
            session.close();
            return "Flight Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating Flight: " + e.getMessage();
        }
    }

    public String updateFlight(Flight flight) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(flight);
            transaction.commit();
            session.close();
            return "Flight Updated Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating Flight: " + e.getMessage();
        }
    }

    public String deleteFlight(Flight flight) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(flight);
            transaction.commit();
            session.close();
            return "Flight Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting Flight: " + e.getMessage();
        }
    }

    public List<Flight> getAllFlights() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Flight> flights = session.createQuery("select flight FROM Flight flight").list();
            session.close();
            return flights;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Flight findFlightById(Flight flight) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Flight flight1 =(Flight) session.get(Flight.class, flight.getFlightId());
            session.close();
            return flight1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
//    public List<Flight> searchFlights(Long departureCityName, Long arrivalCityName, Date departureDate, Date arrivalDate) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Criteria criteria = session.createCriteria(Flight.class);
//
//            // Add restrictions based on the provided parameters
//            if (departureCityName != null) {
//                criteria.createAlias("departureCity", "departureCityAlias");
//                criteria.add(Restrictions.eq("departureCityAlias.name", departureCityName));
//            }
//
//            if (arrivalCityName != null) {
//                criteria.createAlias("arrivalCity", "arrivalCityAlias");
//                criteria.add(Restrictions.eq("arrivalCityAlias.name", arrivalCityName));
//            }
//
//            if (departureDate != null) {
//                criteria.add(Restrictions.ge("departureDateTime", departureDate));
//            }
//
//            if (arrivalDate != null) {
//                criteria.add(Restrictions.le("arrivalDateTime", arrivalDate));
//            }
//
//            return criteria.list();
//        } catch (Exception e) {
//            e.printStackTrace();  // Log or handle the exception appropriately
//            return Collections.emptyList();  // Return an empty list to avoid returning null
//        }
//    }
}
