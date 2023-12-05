package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.AddressJSON;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adr")
    private Long id;
    private String street;
    private State state;
    private String county;
    private double latitude;
    private double longitude;


    public Address() {

    }

    public Address(AddressJSON addressJSON) {
        this.street = addressJSON.street();
        this.state = addressJSON.state();
        this.county = addressJSON.county();
        this.latitude = addressJSON.latitude();
        this.longitude = addressJSON.longitude();
    }

    public Address(Long id, String street, String neighborhood, State state, String county, String zipCode, String pointReference, double latitude, double longitude) {
        this.id = id;
        this.street = street;
        this.state = state;
        this.county = county;
    }

    public Address(Address address) {
        this.street = address.getStreet();
        this.state = address.getState();
        this.county = address.getCounty();
        this.latitude = address.getLatitude();
        this.longitude = address.getLongitude();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
