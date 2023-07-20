package com.example.demo.dto.specialist;

public class GetSpecialistDto {
    private Long id;
    private String name;
    private String type;
    private Integer specialistRating;

    public GetSpecialistDto(Long id, String name,String type, Integer specialistRating) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.specialistRating = specialistRating;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
