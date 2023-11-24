package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.AddressJSON;
import com.felas.ambieep.entites.records.DenunciationJSON;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String neighborhood;
    private State state;
    private String county;
    private String zipCode;
    private String pointReference;
    private double latitude;
    private double logitude;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "denunciation_id", referencedColumnName = "id")
    private Denunciation denunciation;

    public Address() {

    }

    public Address(AddressJSON addressJSON) {
        this.street = addressJSON.street();
        this.neighborhood = addressJSON.neighborhood();
        this.state = addressJSON.state();
        this.county = addressJSON.county();
        this.zipCode = addressJSON.zipCode();
        this.pointReference = addressJSON.pointReference();
        this.latitude = addressJSON.latitude();
        this.logitude = addressJSON.longitude();
    }

    public Address(Long id, String street, String neighborhood, State state, String county, String zipCode, String pointReference, double latitude, double logitude) {
        this.id = id;
        this.street = street;
        this.neighborhood = neighborhood;
        this.state = state;
        this.county = county;
        this.zipCode = zipCode;
        this.pointReference = pointReference;
    }

    public Address(Address address) {
        this.street = address.getStreet();
        this.neighborhood = address.getNeighborhood();
        this.state = address.getState();
        this.county = address.getCounty();
        this.zipCode = address.getZipCode();
        this.pointReference = address.getPointReference();
        this.latitude = address.getLatitude();
        this.logitude = address.getLogitude();
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPointReference() {
        return pointReference;
    }

    public void setPointReference(String pointReference) {
        this.pointReference = pointReference;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLogitude() {
        return logitude;
    }

    public void setLogitude(double logitude) {
        this.logitude = logitude;
    }
}
