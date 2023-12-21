/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.User;

/**
 *
 * @author la paix
 */
public interface UserService extends Remote{
     String createUser(User user) throws RemoteException;

    String updateUser(User user) throws RemoteException;

    String deleteUser(User user) throws RemoteException;

    List<User> getAllUsers() throws RemoteException;

    User findUserById(User user) throws RemoteException;

    User login(String username, String password) throws RemoteException;
}
