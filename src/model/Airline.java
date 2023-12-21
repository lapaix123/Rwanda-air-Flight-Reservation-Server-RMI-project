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
public class Airline implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineId;
    private String airlineName;
    private String contactInfo;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

   

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

    public Airline() {
    }

    public Airline(Long airlineId, String airlineName, String contactInfo, Country country, List<Flight> flights) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.contactInfo = contactInfo;
        this.country = country;
        this.flights = flights;
    }

    public Airline(Long airlineId) {
        this.airlineId = airlineId;
    }
    
    

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    

    
}
