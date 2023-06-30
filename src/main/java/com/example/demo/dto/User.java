package com.example.demo.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "user")

public class User {

    /**
     * Represents client
     */
    private Long user_id;

    private String name;


    private String surname;


    private String email;

    /**
     * @param user_id
     * @param name
     * @param surname
     * @param email
     */
    public User(Long user_id, String name, String surname, String email) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
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
}
