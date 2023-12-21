/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.*;

/**
 *
 * @author la paix
 */
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;   
    private LocalDate bookingaDAte;
    private String status;

    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;

    public Booking() {
    }

    public Booking(Long bookingId, Flight flight, Passenger passenger, LocalDate bookingaDAte, String status, List<Payment> payments) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
        this.bookingaDAte = bookingaDAte;
        this.status = status;
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

    public LocalDate getBookingaDAte() {
        return bookingaDAte;
    }

    public void setBookingaDAte(LocalDate bookingaDAte) {
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
