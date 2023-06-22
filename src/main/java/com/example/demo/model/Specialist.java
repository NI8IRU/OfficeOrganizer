package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

  @Entity
  /**
 * Represents a Specialist in the system.
 */
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialistId;
    private Long officeId;
    private String specialistName;
    private String specialistType;
    private Integer rating;

    /**
     *
     * @param specialistId id and primary key of Specialist
     * @param officeId office assigned to a Specialist (Foreign key of Prenotation)
     * @param specialistName Name of the Specialist
     * @param specialistType Specialized job or mansion
     * @param rating work score of Specialist
     */

    public Specialist(Long specialistId, Long officeId, String specialistName, String specialistType, Integer rating) {
        this.specialistId = specialistId;
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

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
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
