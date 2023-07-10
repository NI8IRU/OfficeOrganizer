package com.example.demo.entity;

import com.example.demo.enums.StatusEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prenotation {

    /**
     * Represents the Prenotation with all the necessary fields
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "specialist_id", referencedColumnName = "id")
    private Specialist specialist_id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    public Prenotation(Long id, Specialist specialist_id, User user, String description, Date date) {
        this.id = id;
        this.specialist_id = specialist_id;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
