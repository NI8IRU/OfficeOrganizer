package com.example.demo.model;

import jakarta.persistence.*; //<-- aggiunto import così da poter usare annotations come 'Entity'!

import java.util.List;

//model ufficio --> Fab11/Frisk11
@Entity
public class Office {

   //Primary key

    private Long id;

    private String officeName;
    private Secretary secretary;
    private List<Specialist> specialists;
    private String phone;
    private String email;
    private Address address;
    private String rating;


    //costruttore vuoto
    public Office() {


    }



    public Office(String officeName, Secretary secretary, List<Specialist> specialists, Address address) {
      this.officeName = officeName;
      this.specialists = specialists;
      this.secretary = secretary;
      this.phone = secretary.getPhone();
      this.email = secretary.getEmail();
      this.address = address;
      this.rating = getRating();
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
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public List<Specialist> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
    }

    public String getRating() {
        double sum = 0.0;
        for (Specialist specialist : this.specialists) {
            sum += specialist.getRating();
        }
        sum /= this.specialists.size();
        rating = String.format("%.1f", sum);

        return  rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "\n  " +
                ", officeName= '" + officeName + '\'' +
                "address: '" + address + '\'' +
                ", phone= '" + phone + '\'' +
                ", email= '" + email + '\'' ;
    }

}



