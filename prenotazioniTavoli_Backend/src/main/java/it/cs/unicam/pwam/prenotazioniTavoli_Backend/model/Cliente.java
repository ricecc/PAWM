package it.cs.unicam.pwam.prenotazioniTavoli_Backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
@Entity(name="clienti")
@Table(name = "clienti")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="nome", nullable = false, length = 255)
    String nome;
    @Column(name="cognome", nullable = false, length = 255)
    String cognome;
    @Column(name="email", nullable = false, length = 255)
    String email;
    @Column(name="citta", nullable = false, length = 255)
    String citta;
    @Column(name="password", nullable = false, length = 255)
    String password;
    @Column(name="username", nullable = false, length = 255)
    String username;
    @Column(name="rol", nullable = false, length = 255)
    String rol;



    public Cliente(){

    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
