/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author la paix
 */
public class PaymentDao {
    public String createPayment(Payment payment) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
            session.close();
            return "Payment Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating Payment: " + e.getMessage();
        }
    }

    public String updatePayment(Payment payment) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(payment);
            transaction.commit();
            session.close();
            return "Payment Updated Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating Payment: " + e.getMessage();
        }
    }

    public String deletePayment(Payment payment) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(payment);
            transaction.commit();
            session.close();
            return "Payment Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting Payment: " + e.getMessage();
        }
    }

    public List<Payment> getAllPayments() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Payment> payments = session.createQuery("select payment FROM Payment payment").list();
            session.close();
            return payments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Payment findPaymentById(Payment payment) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Payment payment1 =(Payment) session.get(Payment.class, payment.getPaymentId());
            session.close();
            return payment1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
