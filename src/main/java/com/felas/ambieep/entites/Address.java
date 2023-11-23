package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.State;
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
    @ManyToOne
    @JoinColumn(name= "county_id", referencedColumnName = "id")
    private County county;
    private String zipCode;
    private String pointReference;
    @OneToOne
    @JoinColumn(name = "geographic_id", referencedColumnName = "id")
    private Geographic geographic;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "denunciation_id", referencedColumnName = "id")
    private Denunciation denunciation;

    public Address(){

    }

    public Address(Long id, String street, String neighborhood, State state, County county, String zipCode, String pointReference, Geographic geographic) {
        this.id = id;
        this.street = street;
        this.neighborhood = neighborhood;
        this.state = state;
        this.county = county;
        this.zipCode = zipCode;
        this.pointReference = pointReference;
        this.geographic = geographic;
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

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
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

    public Geographic getGeographic() {
        return geographic;
    }

    public void setGeographic(Geographic geographic) {
        this.geographic = geographic;
    }
}
