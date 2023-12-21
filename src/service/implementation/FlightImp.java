/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implementation;

import dao.FlightDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Flight;
import service.FlightService;

/**
 *
 * @author la paix
 */
public class FlightImp extends UnicastRemoteObject implements FlightService{

    public FlightImp() throws RemoteException{
        super();
    }
    
    public FlightDao dao = new FlightDao();
    

    @Override
    public String createFlight(Flight flight) throws RemoteException {
      return dao.createFlight(flight);
    }

    @Override
    public String updateFlight(Flight flight) throws RemoteException {
       return dao.updateFlight(flight);
    }

    @Override
    public String deleteFlight(Flight flight) throws RemoteException {
     return dao.deleteFlight(flight);
    }

    @Override
    public List<Flight> getAllFlights() throws RemoteException {
      return dao.getAllFlights();
    }

    @Override
    public Flight findFlightById(Flight flight) throws RemoteException {
     return dao.findFlightById(flight);
    }
    
}
