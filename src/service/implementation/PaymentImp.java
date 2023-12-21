/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implementation;

import dao.PaymentDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Payment;
import service.PaymentService;

/**
 *
 * @author la paix
 */
public class PaymentImp extends UnicastRemoteObject implements PaymentService{

    public PaymentImp() throws RemoteException{
        super();
    }
    public PaymentDao dao= new PaymentDao();
    

     @Override
    public String createPayment(Payment payment) throws RemoteException {
        try {
            return dao.createPayment(payment);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating Payment: " + e.getMessage();
        }
    }

    @Override
    public String updatePayment(Payment payment) throws RemoteException {
        try {
            return dao.updatePayment(payment);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating Payment: " + e.getMessage();
        }
    }

    @Override
    public String deletePayment(Payment payment) throws RemoteException {
        try {
            return dao.deletePayment(payment);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting Payment: " + e.getMessage();
        }
    }

    @Override
    public List<Payment> getAllPayments() throws RemoteException {
        try {
            return dao.getAllPayments();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Payment findPaymentById(Payment payment) throws RemoteException {
        try {
            return dao.findPaymentById(payment);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
