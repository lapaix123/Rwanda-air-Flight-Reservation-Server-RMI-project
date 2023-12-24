/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Booking;
import model.Passenger;

/**
 *
 * @author la paix
 */
public interface BookingService extends Remote{
     String createBooking(Booking booking) throws RemoteException;

    String updateBooking(Booking booking)throws RemoteException;

    String deleteBooking(Booking booking)throws RemoteException;

    List<Booking> getAllBookings()throws RemoteException;

    Booking findBookingById(Booking booking)throws RemoteException;
   List<Booking> findBookingsByPassenger(Passenger passenger) throws RemoteException;
}
