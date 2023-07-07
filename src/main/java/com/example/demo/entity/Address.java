package com.example.demo.entity;

import jakarta.persistence.*;

/**
 * It helps to set the office's address
 */
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;

    private Integer postalCode;
    private String city;
    private String additionalInformation;
    @OneToOne
    @JoinColumn(name = "office_id")
    private Office office;


    /**
     * @param street                the street near the office
     * @param postalCode            office's cap
     * @param city                  city where its located the office
     * @param additionalInformation additional info about the office
     * @param office                office in this address
     */
    public Address(String street, Integer postalCode, String city, String additionalInformation, Office office) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.additionalInformation = additionalInformation;
        this.office = office;
    }

    /**
     * Empty constructor
     */
    public Address() {
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the street where the office its located
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for th office's street
     *
     * @param street office's street
     */

    public void setStreet(String street) {
        this.street = street;
    }


    /**
     * @return office's cap
     */
    public Integer getPostalCode() {
        return postalCode;
    }

    /**
     * Setter for the office's cap
     *
     * @param postalCode office's cap
     */

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the city where the office its located
     */

    public String getCity() {
        return city;
    }

    /**
     * Setter for the city where the office its located
     *
     * @param city city where the office its located
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return additional info about the office
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Setter for office's additional info
     *
     * @param additionalInformation additional info about the office
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
