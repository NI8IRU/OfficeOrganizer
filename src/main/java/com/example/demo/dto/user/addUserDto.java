package com.example.demo.dto.user;

import com.example.demo.entity.Prenotation;
import jakarta.persistence.Column;

import java.util.List;

public class addUserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private List<Prenotation> prenotations;

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
}
