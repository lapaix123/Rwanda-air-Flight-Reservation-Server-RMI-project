/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Airline;

/**
 *
 * @author la paix
 */
public interface AirlineService extends Remote{
    String createAirline(Airline airline) throws RemoteException;

    String updateAirline(Airline airline) throws RemoteException;

    String deleteAirline(Airline airline) throws RemoteException;

    List<Airline> getAllAirlines() throws RemoteException;

    Airline findAirlineById(Airline airline) throws RemoteException;
}
