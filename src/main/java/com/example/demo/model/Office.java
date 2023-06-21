package com.example.demo.model;

import com.example.demo.model.record.Address;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*; //<-- aggiunto import così da poter usare annotations come 'Entity'!

//model ufficio --> Fab11/Frisk11
@Entity
public class Office {

   //Primary key

    private Integer id;

    private String officeName;

    //Foreign key di tipo segretario, da implementare ancora il model
//   private List<Secretary> secretaries;
    private String phone;
    private String email;

    private Address address;


    //costruttore vuoto
    public Office() {


    }



    public Office(String officeName, String phone, String email, Address address) {
      this.officeName = officeName;
      this.phone = phone;
      this.email = email;
      this.address = address;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "\n  " +
                ", officeName= '" + officeName + '\'' +
                "address: '" + address + '\'' +
                ", phone= '" + phone + '\'' +
                ", email= '" + email + '\'' ;
    }

}



