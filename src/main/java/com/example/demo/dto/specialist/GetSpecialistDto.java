package com.example.demo.dto.specialist;

public class GetSpecialistDto {
    private String name;
    private String officeName;
    private String type;
    private Integer specialistRating;

    public GetSpecialistDto(String name, String officeName, String type, Integer specialistRating) {
        this.name = name;
        this.officeName = officeName;
        this.type = type;
        this.specialistRating = specialistRating;
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
