package com.example.demo.dto;


/**
 *It helps to set the office's address
 */

public class Address {

    private Long id;
    private String street;
    private String district;
    private Integer houseNumber;
    private Integer cap;
    private String city;
    private String additionalInformation;

    private Office office;


    /**
     *
     * @param street the street near the office
     * @param district the district where its located the office
     * @param houseNumber office's house number
     * @param cap   office's cap
     * @param city city where its located the office
     * @param additionalInformation additional info about the office
     * @param office office in this address
     */
    public Address(String street, String district, Integer houseNumber, Integer cap, String city, String additionalInformation, Office office) {
        this.street = street;
        this.district = district;
        this.houseNumber = houseNumber;
        this.cap = cap;
        this.city = city;
        this.additionalInformation = additionalInformation;
        this.office = office;
    }

    /**
     * Empty constructor
     */
    public Address() {}

    /**
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the street where the office its located
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for th office's street
     * @param street office's street
     */

    public void setStreet(String street) {
        this.street = street;
    }


    /**
     *
     * @return the district where the office its located
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Setter for the district
     * @param district office's district
     */

    public void setDistrict(String district) {
        this.district = district;
    }


    /**
     *
     * @return office's house number
     */
    public Integer getHouseNumber() {
        return houseNumber;
    }

    /**
     * Setter for the office's house number
     * @param houseNumber office's house number
     */
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     *
     * @return office's cap
     */
    public Integer getCap() {
        return cap;
    }

    /**
     * Setter for the office's cap
     * @param cap office's cap
     */

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    /**
     *
     * @return the city where the office its located
     */

    public String getCity() {
        return city;
    }

    /**
     * Setter for the city where the office its located
     * @param city city where the office its located
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return additional info about the office
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Setter for office's additional info
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
