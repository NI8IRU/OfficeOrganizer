package com.example.demo.dto;

/**
 * Represents a Specialist in the system.
 */


public class Specialist {
    private Long id;
    private Long officeId;


    private String specialistName;

    private String specialistType;

    private Integer rating;

    /**
     *
     * @param id id and primary key of Specialist
     * @param officeId office assigned to a Specialist (Foreign key of Prenotation)
     * @param specialistName Name of the Specialist
     * @param specialistType Specialized job or mansion
     * @param rating work score of Specialist
     */

    public Specialist(Long id, Long officeId, String specialistName, String specialistType, Integer rating) {
        this.id = id;
        this.officeId = officeId;
        this.specialistName = specialistName;
        this.specialistType = specialistType;
        this.rating = rating;
    }

    /**
     * Empty constructor
     */
    public Specialist (){

    }

    /**
     * Getters and Setters of Specialist class
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }

    public Integer getRating() {
        return rating;
    }
}
