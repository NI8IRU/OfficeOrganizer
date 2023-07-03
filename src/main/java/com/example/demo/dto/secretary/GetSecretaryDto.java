package com.example.demo.dto.secretary;

public class GetSecretaryDto {
    private String name;
    private String officeName;
    private String phone;
    private String email;

    public GetSecretaryDto(String name, String officeName, String phone, String email) {
        this.name = name;
        this.officeName = officeName;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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
}
