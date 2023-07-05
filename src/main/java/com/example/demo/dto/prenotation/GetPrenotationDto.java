package com.example.demo.dto.prenotation;

import com.example.demo.entity.Specialist;
import com.example.demo.entity.User;

import java.util.Date;

public class GetPrenotationDto {

    private Long id;
    private Specialist specialist_id;
    private User user_id;
    private String description;
    private Date date;

    public GetPrenotationDto(Specialist specialist_id, User user_id, String description, Date date) {
        this.specialist_id = specialist_id;
        this.user_id = user_id;
        this.description = description;
        this.date = date;
    }

    public GetPrenotationDto(){

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
