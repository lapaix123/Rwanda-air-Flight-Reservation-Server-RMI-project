/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implementation;

import dao.BookingDao;
import java.rmi.RemoteException;
import java.util.List;
import model.Booking;
import service.BookingService;

/**
 *
 * @author la paix
 */
public class BookingImp implements BookingService{

    public BookingImp() {
        super();
    }
    public BookingDao dao= new BookingDao();

    @Override
    public String createBooking(Booking booking) throws RemoteException {
       return dao.createBooking(booking);
    }

    @Override
    public String updateBooking(Booking booking) throws RemoteException {
      return dao.updateBooking(booking);
    }

    @Override
    public String deleteBooking(Booking booking) throws RemoteException {
      return dao.deleteBooking(booking);
    }

    @Override
    public List<Booking> getAllBookings() throws RemoteException {
        return dao.getAllBookings();
    }

    @Override
    public Booking findBookingById(Booking booking) throws RemoteException {
     return dao.findBookingById(booking);
    }
    
}
