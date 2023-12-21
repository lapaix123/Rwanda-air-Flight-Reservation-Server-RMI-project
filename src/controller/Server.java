package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import service.*;
import service.implementation.AirlineImp;
import service.implementation.CountryImp;
import service.implementation.FlightImp;
import service.implementation.PassengerImp;
import service.implementation.PaymentImp;
import service.implementation.UserImp;

public class Server extends UnicastRemoteObject {

    private AirlineService airlineService;
    private CountryService countryService;
    private FlightService flightService;
    private PassengerService passengerService;
    private PaymentService paymentService;
    private UserService userService;

    public Server() throws RemoteException {
        this.airlineService = new AirlineImp();
        this.countryService = new CountryImp();
        this.flightService = new FlightImp();
        this.passengerService = new PassengerImp();
        this.paymentService = new PaymentImp();
        this.userService = new UserImp();
    }

    public static void main(String[] args) {       
        
        try {
            // Set property
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            
            // Create registry
            Registry registry = LocateRegistry.createRegistry(6000);
            
            // Create server and bind services
            Server server = new Server();
            registry.rebind("airlineService", server.airlineService);
            registry.rebind("countryService", server.countryService);
            registry.rebind("flightService", server.flightService);
            registry.rebind("passengerService", server.passengerService);
            registry.rebind("paymentService", server.paymentService);
            registry.rebind("userService", server.userService);
            
            System.out.println("Rwanada Air is Running on port 6000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
