package com.example.demo.entity;

import com.example.demo.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Represents a Secretary in the system.
 */
@Entity
@Table(name = "secretary")
public class Secretary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_office")
    @JsonBackReference
    private Office office;
    @Column(name = "secretary_name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    /**
     * Returns the ID of the secretary.
     *
     * @return The ID of the secretary.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the secretary.
     *
     * @param id The ID of the secretary.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the office of the secretary.
     *
     * @return The office of the secretary.
     */
    public Office getOffice() {
        return office;
    }

    /**
     * Sets the office of the secretary.
     *
     * @param office The office of the secretary.
     */
    public void setOffice(Office office) {
        this.office = office;
    }

    /**
     * Returns the name of the secretary.
     *
     * @return The name of the secretary.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the secretary.
     *
     * @param name The name of the secretary.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the phone number of the secretary.
     *
     * @return The phone number of the secretary.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the secretary.
     *
     * @param phone The phone number of the secretary.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the email address of the secretary.
     *
     * @return The email address of the secretary.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the secretary.
     *
     * @param email The email address of the secretary.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the current status of the secretary.
     *
     * @return The current status of the secretary.
     */
    public StatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the status of the secretary.
     *
     * @param status The email address of the secretary.
     */
    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}