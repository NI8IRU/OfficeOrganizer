package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prenotation {

    /**
     * Represents the Prenotation with all the necessary fields
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "specialist_id", referencedColumnName = "id")
    private Specialist specialist_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @Column(name = "description")

    private String description;
    @Column(name = "date")
    private Date date;

    public Prenotation(Long id, Specialist specialist_id, User user_id, String description, Date date) {
        this.id = id;
        this.specialist_id = specialist_id;
        this.user_id = user_id;
        this.description = description;
        this.date = date;
    }

    public Prenotation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Specialist getSpecialist_id() {
        return specialist_id;
    }

    public void setSpecialist_id(Specialist specialist_id) {
        this.specialist_id = specialist_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
