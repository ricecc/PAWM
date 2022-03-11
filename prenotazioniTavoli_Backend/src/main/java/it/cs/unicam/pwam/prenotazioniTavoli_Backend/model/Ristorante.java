package it.cs.unicam.pwam.prenotazioniTavoli_Backend.model;

import javax.persistence.*;

@Entity(name="ristorante")
@Table(name = "ristorante")
public class Ristorante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nomeRistorante")
    String nomeRistorante;
    @Column(name="città")
    String città;
    @Column(name="email")
    String email;
    @Column(name="postiMax")
    int postiMax;

    public Ristorante(){

    }

    public Ristorante(String nomeRistorante, String città, String email, int postiMax) {
        this.nomeRistorante = nomeRistorante;
        this.città = città;
        this.email = email;
        this.postiMax = postiMax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRistorante() {
        return nomeRistorante;
    }

    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPostiMax() {
        return postiMax;
    }

    public void setPostiMax(int postiMax) {
        this.postiMax = postiMax;
    }
}
