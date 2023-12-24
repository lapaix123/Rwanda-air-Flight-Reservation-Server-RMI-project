/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Booking;
import model.Passenger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author la paix
 */
public class BookingDao {

    public String createBooking(Booking booking) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(booking);
            transaction.commit();
            session.close();
            return "Booking Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating Booking: " + e.getMessage();
        }
    }

    public String updateBooking(Booking booking) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(booking);
            transaction.commit();
            session.close();
            return "Booking Updated Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating Booking: " + e.getMessage();
        }
    }

    public String deleteBooking(Booking booking) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(booking);
            transaction.commit();
            session.close();
            return "Booking Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting Booking: " + e.getMessage();
        }
    }

    public List<Booking> getAllBookings() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Booking> bookings = session.createQuery("select booking FROM Booking booking").list();
            session.close();
            return bookings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Booking findBookingById(Booking booking) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Booking booking1 = (Booking) session.get(Booking.class, booking.getBookingId());
            session.close();
            return booking1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Booking> findBookingsByPassenger(Passenger passenger) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Booking b WHERE b.passenger = :passenger");
            query.setParameter("passenger", passenger);
            List<Booking> bookings = query.list();
            session.close();
            return bookings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
