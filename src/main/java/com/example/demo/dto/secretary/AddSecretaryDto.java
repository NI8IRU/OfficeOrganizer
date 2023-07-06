package com.example.demo.dto.secretary;

public class AddSecretaryDto extends SecretaryDto{

    private Long officeId;

    public AddSecretaryDto(String name, String phone, String email, Long officeId) {
        super(name, phone, email);
        this.officeId = officeId;
    }


    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }


}
