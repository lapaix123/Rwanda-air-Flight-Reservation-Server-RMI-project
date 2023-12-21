/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author la paix
 */
public class UserDao {
     public String createUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            return "User Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating User: " + e.getMessage();
        }
    }

    public String updateUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            session.close();
            return "User Updated Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating User: " + e.getMessage();
        }
    }

    public String deleteUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            session.close();
            return "User Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting User: " + e.getMessage();
        }
    }

    public List<User> getAllUsers() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<User> users = session.createQuery("select user FROM User user").list();
            session.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findUserById(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            User user1 =(User) session.get(User.class, user.getUserId());
            session.close();
            return user1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
      public User login(String username, String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            // Using HQL to retrieve the User with the provided username and password
            String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
            User user = (User) session.createQuery(hql)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            transaction.commit();
            session.close();

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
