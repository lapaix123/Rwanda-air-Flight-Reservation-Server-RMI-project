/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implementation;

import dao.AirlineDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Airline;
import service.AirlineService;

/**
 *
 * @author la paix
 */
public class AirlineImp extends UnicastRemoteObject implements AirlineService{

    public AirlineImp() throws RemoteException{
        super();
    }
    
    
   public AirlineDao dao= new AirlineDao();

    @Override
    public String createAirline(Airline airline) throws RemoteException {
      return  dao.newAirline(airline);
    }

    @Override
    public String updateAirline(Airline airline) throws RemoteException {
    return dao.updateAirline(airline);
    }

    @Override
    public String deleteAirline(Airline airline) throws RemoteException {
        return dao.deleteAirline(airline);
      }

    @Override
    public List<Airline> getAllAirlines() throws RemoteException {
        return dao.airlineListe();
    }

    @Override
    public Airline findAirlineById(Airline airline) throws RemoteException {
       return dao.findById(airline);
    }
    
}
