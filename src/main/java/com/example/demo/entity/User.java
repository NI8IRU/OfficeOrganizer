package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")

public class User {

    /**
     * Represents client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")

    private String surname;

    @Column(name = "email")

    private String email;

    @Column (name ="prenotation")
    private List<Prenotation> prenotations;

    /**
     * @param user_id
     * @param name
     * @param surname
     * @param email
     * @param prenotations
     */
    public User(Long user_id, String name, String surname, String email, List<Prenotation> prenotations) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.prenotations = prenotations;
    }
    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
}
