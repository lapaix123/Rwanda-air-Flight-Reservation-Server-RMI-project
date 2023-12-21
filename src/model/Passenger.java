/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author la paix
 */
@Entity
public class Passenger implements Serializable{
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    @Column(unique = true)
    private String email;

    private String fNames;
    private String lnames;

    @Column(unique = true)
    private String phone;

    private String address;
    private String password;

    @Column(unique = true)
    private String nId;

    // Other fields specific to the Passenger entity

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;

    public Passenger() {
    }

    public Passenger(Long passengerId, String email, String fNames, String lnames, String phone, String address, String password, String nId, List<Booking> bookings) {
        this.passengerId = passengerId;
        this.email = email;
        this.fNames = fNames;
        this.lnames = lnames;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.nId = nId;
        this.bookings = bookings;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfNames() {
        return fNames;
    }

    public void setfNames(String fNames) {
        this.fNames = fNames;
    }

    public String getLnames() {
        return lnames;
    }

    public void setLnames(String lnames) {
        this.lnames = lnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
}
