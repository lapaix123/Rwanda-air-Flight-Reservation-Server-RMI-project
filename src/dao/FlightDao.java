/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Flight;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
