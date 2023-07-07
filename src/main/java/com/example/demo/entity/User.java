package com.example.demo.entity;

import com.example.demo.enums.StatusEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")

public class User {

    /**
     * Represents client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "prenotation")
    private List<Prenotation> prenotations;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;



    /**
     * @param name
     * @param surname
     * @param email
     * @param prenotations
     * @param status
     */
    public User(String name, String surname, String email, List<Prenotation> prenotations, StatusEnum status) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.prenotations = prenotations;
        this.status = status;
    }


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Prenotation> getPrenotations() {
        return prenotations;
    }

    public void setPrenotations(List<Prenotation> prenotations) {
        this.prenotations = prenotations;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
