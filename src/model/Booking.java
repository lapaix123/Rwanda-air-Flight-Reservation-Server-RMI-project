/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.*;

/**
 *
 * @author la paix
 */
@Entity
public class Booking implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger passenger;   
    private Date bookingaDAte;
    private String status;
    private Integer numberOfbook;

    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;

    public Booking() {
    }

    public Integer getNumberOfbook() {
        return numberOfbook;
    }

    public void setNumberOfbook(Integer numberOfbook) {
        this.numberOfbook = numberOfbook;
    }

    public Booking(Long bookingId, Flight flight, Passenger passenger, Date bookingaDAte, String status, Integer numberOfbook, List<Payment> payments) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
        this.bookingaDAte = bookingaDAte;
        this.status = status;
        this.numberOfbook = numberOfbook;
        this.payments = payments;
    }

    

    public Booking(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getBookingaDAte() {
        return bookingaDAte;
    }

    public void setBookingaDAte(Date bookingaDAte) {
        this.bookingaDAte = bookingaDAte;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    
    
}
