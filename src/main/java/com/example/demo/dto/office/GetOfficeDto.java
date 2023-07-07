package com.example.demo.dto.office;

import com.example.demo.entity.Address;
import com.example.demo.entity.Secretary;
import com.example.demo.entity.Specialist;
import com.example.demo.enums.StatusEnum;

import java.util.List;

public class GetOfficeDto {

    private Long Id;
    private String officeName;
    private Secretary secretary;
    private List<Specialist> specialists;


    private String phone;
    private String email;
    private Address address;
    private Double rating;


    private StatusEnum status;

    public GetOfficeDto() {
    }

    public GetOfficeDto(String officeName, Secretary secretary, List<Specialist> specialists,
                        String phone, String email, Address address, Double rating, StatusEnum status) {
        this.officeName = officeName;
        this.secretary = secretary;
        this.specialists = specialists;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.rating = rating;
        this.status = status;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public List<Specialist> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
