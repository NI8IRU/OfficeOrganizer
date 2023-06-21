package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

@Entity
public class User {

    /**
     * Represents client
     */
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long user_id;
    private String nome;
    private String cognome;
    private String email;

    /**
     *
     * @param user_id
     * @param nome
     * @param cognome
     * @param email
     */
    public User(Long user_id, String nome, String cognome, String email) {
        this.user_id = user_id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
