/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Passenger;

/**
 *
 * @author la paix
 */
public interface PassengerService extends Remote{
     String createPassenger(Passenger passenger) throws RemoteException;

    String updatePassenger(Passenger passenger) throws RemoteException;

    String deletePassenger(Passenger passenger) throws RemoteException;

    List<Passenger> getAllPassengers() throws RemoteException;

    Passenger findPassengerById(Passenger passenger) throws RemoteException;

    Passenger login(String email, String password) throws RemoteException;
}
