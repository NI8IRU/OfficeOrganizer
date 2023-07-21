package com.example.demo.entity;

import com.example.demo.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

  /**
 * Represents a Specialist in the system.
 */

  @Entity
  @Table(name = "specialist")
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonBackReference
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_office", referencedColumnName = "id")
    @JsonBackReference
    private Office office;

    @Column(name = "specialist_name")

    private String specialistName;
    @Column(name = "specialist_type")

    private String specialistType;

    @Column(name = "rating")
    private Integer rating;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;


    /**
     *
     * @param id id and primary key of Specialist
     * @param office office assigned to a Specialist (Foreign key of Prenotation)
     * @param specialistName Name of the Specialist
     * @param specialistType Specialized job or mansion
     * @param rating work score of Specialist
     */

    public Specialist(Long id, Office office, String specialistName, String specialistType, Integer rating) {
        this.id = id;
        this.office = office;
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
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

      public void setRating(Integer rating) {
          this.rating = rating;
      }

      public StatusEnum getStatus() {
          return status;
      }

      public void setStatus(StatusEnum status) {
          this.status = status;
      }
  }
