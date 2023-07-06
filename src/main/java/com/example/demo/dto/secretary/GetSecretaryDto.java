package com.example.demo.dto.secretary;

public class GetSecretaryDto extends SecretaryDto{
    private String officeName;

    public GetSecretaryDto(String name, String phone, String email, String officeName) {
        super(name, phone, email);
        this.officeName = officeName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
