package com.example.demo.dto.office;


import java.util.List;

public class CreateOfficeDto {


    private Long id;
    private String officeName;
    private String secretary;
    private List<String> specialists;


    private String phone;

    private String email;

    private String address;
    private Double rating;


    public CreateOfficeDto(String officeName, String secretary, List<String> specialists, String phone, String email, String address, Double rating) {
        this.officeName = officeName;
        this.secretary = secretary;
        this.specialists = specialists;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.rating = rating;
    }


    public CreateOfficeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public List<String> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(List<String> specialists) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


}
