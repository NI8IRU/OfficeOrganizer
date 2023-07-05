package com.example.demo.dto.user;

import com.example.demo.entity.Prenotation;

import java.util.List;

public class GetUserDto {
    private String name;
    private String surname;
    private List<Prenotation> prenotations;

    public GetUserDto(String name, String surname, List<Prenotation> prenotations) {
        this.name = name;
        this.surname = surname;
        this.prenotations = prenotations;
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

    public List<Prenotation> getPrenotations() {
        return prenotations;
    }

    public void setPrenotations(List<Prenotation> prenotations) {
        this.prenotations = prenotations;
    }
}
