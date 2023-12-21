/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Flight;

/**
 *
 * @author la paix
 */
public interface FlightService extends Remote{
   String createFlight(Flight flight) throws RemoteException;

    String updateFlight(Flight flight) throws RemoteException;

    String deleteFlight(Flight flight) throws RemoteException;

    List<Flight> getAllFlights() throws RemoteException;

    Flight findFlightById(Flight flight) throws RemoteException; 
}
