package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Specialist {
    private Integer rating;

    public Integer getRating() {
        return rating;
    }
}
