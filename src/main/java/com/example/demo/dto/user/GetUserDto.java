package com.example.demo.dto.user;

import com.example.demo.entity.Prenotation;

import java.util.List;

public class GetUserDto {
    private String name;
    private String surname;
    private List<Prenotation> prenotation;

    public GetUserDto(String name, String surname, List<Prenotation> prenotation) {
        this.name = name;
        this.surname = surname;
        this.prenotation = prenotation;
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

    public List<Prenotation> getPrenotation() {
        return prenotation;
    }

    public void setPrenotation(List<Prenotation> prenotation) {
        this.prenotation = prenotation;
    }
}
