package com.example.demo.entity;

import com.example.demo.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * Represents the office, it helps to set default information
 * such as the office's name, the office's phone number and
 * the office's address, it also contains a list of specialist
 * and an object type secretary
 */
@Entity
@Table(name = "office")

public class Office {

    /**
     * Primary Key, auto_incrementer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "office_name")
    private String officeName;
    @OneToOne(mappedBy = "office")
    @JoinColumn(name = "id_secretary", referencedColumnName = "id")
    @JsonManagedReference
    private Secretary secretary;
    @JsonManagedReference
    @OneToMany(mappedBy = "office")
    private List<Specialist> specialists;

    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @JsonManagedReference
    @OneToOne(mappedBy = "office")
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private Double rating;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;


    /**
     * Empty constructor
     */
    public Office() {


    }


    /**
     * @param officeName  Office's name
     * @param secretary   Represents a secretary - Object type: Secretary
     * @param specialists A list of specialists - Object type: Specialist
     * @param address     Office's address  - Object type: Address
     */
    public Office(String officeName, Secretary secretary, List<Specialist> specialists, Address address, Double rating) {
        this.officeName = officeName;
        this.specialists = specialists;
        this.secretary = secretary;
        this.phone = secretary.getPhone();
        this.email = secretary.getEmail();
        this.address = address;
        this.rating = rating;
    }

    /**
     * @return office's id
     */
    public Long getId() {
        return id;
    }

    /**
     * To set the id of the office
     *
     * @param id Office's id, in the database it's a primary key
     *           -object type: Long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return office's name
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * Setter for office's name
     *
     * @param officeName office's name
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * @return the phone number of the office
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for the phone number
     *
     * @param phone office's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return office's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email
     *
     * @param email office's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return office's the address
     */

    public Address getAddress() {
        return address;
    }

    /**
     * @param address address of the office -
     *                Object type: Address
     */

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the secretary
     */
    public Secretary getSecretary() {
        return secretary;
    }

    /**
     * Setter for the secretary
     *
     * @param secretary Object type: Secretary
     */

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    /**
     * @return the list of the specialists
     */
    public List<Specialist> getSpecialists() {
        return specialists;
    }

    /**
     * Setter for the list of specialists
     *
     * @param specialists list - object type: Specialist
     */
    public void setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
    }

    /**
     * @return the rating of the office
     */
    public Double getRating() {
        rating = 0.0;
        for (Specialist specialist : specialists) {
            rating += specialist.getRating();
        }
        rating /= specialists.size();

        return rating;
    }

    /**
     * Setter for the rating
     *
     * @param rating office's rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     * It helps to print the office in an aesthetically prettier way
     */
    public void printOffice() {
        System.out.println("\n  " +
                officeName + '\'' +
                "address: '" + address + '\'' +
                ", phone= '" + phone + '\'' +
                ", email= '" + email + '\'');
    }

}


