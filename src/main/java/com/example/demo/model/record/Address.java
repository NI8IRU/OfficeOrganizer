package com.example.demo.model.record;

//record semplice per l'indirizzo dell'ufficio
//via, provincia, numCivico, cap, città e informazioni aggiuntive
public record Address(String street, String district, int numCivico, int cap, String city, String
        additionalInformation) {

    public void printAddress(){

        System.out.println("\n" + street +  numCivico + " "
                + cap +  " " +  city + " " +district
                + "\n  " +additionalInformation);
    }

}
