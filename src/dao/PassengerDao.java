/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author la paix
 */
public class PassengerDao {
    public String createPassenger(Passenger passenger) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(passenger);
            transaction.commit();
            session.close();
            return "Passenger Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating Passenger: " + e.getMessage();
        }
    }

    public String updatePassenger(Passenger passenger) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(passenger);
            transaction.commit();
            session.close();
            return "Passenger Updated Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating Passenger: " + e.getMessage();
        }
    }

    public String deletePassenger(Passenger passenger) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(passenger);
            transaction.commit();
            session.close();
            return "Passenger Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting Passenger: " + e.getMessage();
        }
    }

    public List<Passenger> getAllPassengers() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Passenger> passengers = session.createQuery("select passenger FROM Passenger passenger").list();
            session.close();
            return passengers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Passenger findPassengerById(Passenger passenger) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Passenger passenger1 =(Passenger) session.get(Passenger.class, passenger.getPassengerId());
            session.close();
            return passenger1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public Passenger login(String email, String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            // Using HQL to retrieve the Passenger with the provided email and password
            String hql = "FROM Passenger p WHERE p.email = :email AND p.password = :password";
            Passenger passenger = (Passenger) session.createQuery(hql)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();

            transaction.commit();
            session.close();

            return passenger;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
