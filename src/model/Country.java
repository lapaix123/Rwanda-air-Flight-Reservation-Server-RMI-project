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
public class Country implements Serializable{
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    private String countryName;

    // Other fields specific to the Country entity

    @OneToMany(mappedBy = "country")
    private List<Airline> airlines;

    public Country() {
    }

    public Country(Long countryId, String countryName, List<Airline> airlines) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.airlines = airlines;
    }

    public Country(Long countryId) {
        this.countryId = countryId;
    }
    

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }
    
    
    
}
