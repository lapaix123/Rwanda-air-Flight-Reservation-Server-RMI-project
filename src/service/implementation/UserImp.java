/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implementation;

import dao.UserDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.User;
import service.UserService;

/**
 *
 * @author la paix
 */
public class UserImp extends UnicastRemoteObject implements UserService{

    public UserImp() throws RemoteException{
        super();
    }
    public UserDao dao= new UserDao();
    

    @Override
    public String createUser(User user) throws RemoteException {
        try {
            return dao.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating User: " + e.getMessage();
        }
    }

    @Override
    public String updateUser(User user) throws RemoteException {
        try {
            return dao.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating User: " + e.getMessage();
        }
    }

    @Override
    public String deleteUser(User user) throws RemoteException {
        try {
            return dao.deleteUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting User: " + e.getMessage();
        }
    }

    @Override
    public List<User> getAllUsers() throws RemoteException {
        try {
            return dao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUserById(User user) throws RemoteException {
        try {
            return dao.findUserById(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User login(String username, String password) throws RemoteException {
        try {
            return dao.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
