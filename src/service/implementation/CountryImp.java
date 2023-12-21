/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implementation;

import dao.CountryDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Country;
import service.CountryService;

/**
 *
 * @author la paix
 */
public class CountryImp extends UnicastRemoteObject implements CountryService{

    public CountryImp() throws RemoteException{
        super();
    }
    public CountryDao dao= new CountryDao();

    @Override
    public String createCountry(Country country) throws RemoteException {
       return dao.createCountry(country);
    }

    @Override
    public String updateCountry(Country country) throws RemoteException {
      return dao.updateCountry(country);
    }

    @Override
    public String deleteCountry(Country country) throws RemoteException {
       return dao.deleteCountry(country);
    }

    @Override
    public List<Country> getAllCountries() throws RemoteException {
      return dao.getAllCountries();
    }

    @Override
    public Country findCountryById(Country country) throws RemoteException {
    return dao.findCountryById(country);
    }
    
}
