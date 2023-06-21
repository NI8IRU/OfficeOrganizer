package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//record semplice per l'indirizzo dell'ufficio
//via, provincia, numCivico, cap, città e informazioni aggiuntive
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String district;
    private Integer numCivico;
    private Integer cap;
    private String city;
    private String additionalInformation;

    public Address(String street, String district, Integer numCivico, Integer cap, String city, String additionalInformation) {
        this.street = street;
        this.district = district;
        this.numCivico = numCivico;
        this.cap = cap;
        this.city = city;
        this.additionalInformation = additionalInformation;
    }

    public Address() {}

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getNumCivico() {
        return numCivico;
    }

    public void setNumCivico(Integer numCivico) {
        this.numCivico = numCivico;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
