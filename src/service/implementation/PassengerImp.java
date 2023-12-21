/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implementation;

import dao.PassengerDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Passenger;
import service.PassengerService;

/**
 *
 * @author la paix
 */
public class PassengerImp extends UnicastRemoteObject implements PassengerService{

    public PassengerImp() throws RemoteException{
        super();
    }
    public  PassengerDao dao= new PassengerDao();
    

  @Override
    public String createPassenger(Passenger passenger) throws RemoteException {
        try {
            return dao.createPassenger(passenger);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating Passenger: " + e.getMessage();
        }
    }

    @Override
    public String updatePassenger(Passenger passenger) throws RemoteException {
        try {
            return dao.updatePassenger(passenger);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating Passenger: " + e.getMessage();
        }
    }

    @Override
    public String deletePassenger(Passenger passenger) throws RemoteException {
        try {
            return dao.deletePassenger(passenger);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting Passenger: " + e.getMessage();
        }
    }

    @Override
    public List<Passenger> getAllPassengers() throws RemoteException {
        try {
            return dao.getAllPassengers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Passenger findPassengerById(Passenger passenger) throws RemoteException {
        try {
            return dao.findPassengerById(passenger);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Passenger login(String email, String password) throws RemoteException {
        try {
            return dao.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
