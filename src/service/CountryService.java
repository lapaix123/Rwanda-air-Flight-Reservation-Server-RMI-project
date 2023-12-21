/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Country;

/**
 *
 * @author la paix
 */
public interface CountryService extends Remote{
    
    String createCountry(Country country) throws RemoteException;

    String updateCountry(Country country) throws RemoteException;

    String deleteCountry(Country country) throws RemoteException;

    List<Country> getAllCountries() throws RemoteException;

    Country findCountryById(Country country) throws RemoteException;
    
}
