/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Payment;

/**
 *
 * @author la paix
 */
public interface PaymentService extends Remote{
     String createPayment(Payment payment) throws RemoteException;

    String updatePayment(Payment payment) throws RemoteException;

    String deletePayment(Payment payment) throws RemoteException;

    List<Payment> getAllPayments() throws RemoteException;

    Payment findPaymentById(Payment payment) throws RemoteException;
}
