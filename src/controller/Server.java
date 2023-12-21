/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author la paix
 */
public class Server extends UnicastRemoteObject {

    public Server() throws RemoteException{
    }

   

    public static void main(String[] args) {
        try {
            //set property
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            //create registry
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.rebind("client", new Server());
            System.out.println("Rwanada Air is Running on port 6000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
