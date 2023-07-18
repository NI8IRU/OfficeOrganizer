package com.example.demo.dto.specialist;

public class AddSpecialistDto {
    private Long officeId;
    private String name;
    private String type;
    private Integer specialistRating;

    public AddSpecialistDto(String name, String type, Integer specialistRating) {
        this.name = name;
        this.type = type;
        this.specialistRating = specialistRating;
    }

    public Long getOfficeId() {
       return officeId;
    }

   public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSpecialistRating() {
        return specialistRating;
    }

    public void setSpecialistRating(Integer specialistRating) {
        this.specialistRating = specialistRating;
    }
}
