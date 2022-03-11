package it.cs.unicam.pwam.prenotazioniTavoli_Backend.model;

import javax.persistence.*;

@Entity(name="prenotazioni")
@Table(name="prenotazioni")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="nome", nullable = false)
    String nome;
    @Column(name="guest", nullable = false)
    int numGuest;
    @Column(name="giorno", nullable = false)
    String dataPrenotazione;
    @Column(name="start", nullable = false)
    String start;
    @Column(name="usernameCliente", nullable = false)
    String usernameCliente;
    @Column(name="nomeRistorante", nullable = false)
    String nomeRistorante;


    public String getNomeRistorante() {
        return nomeRistorante;
    }

    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    public Prenotazione() {

    }

    public Prenotazione(String nome, int numGuest, String dataPrenotazione, String start,String usernameCliente) {
        this.nome = nome;
        this.numGuest = numGuest;
        this.dataPrenotazione = dataPrenotazione;
        this.start = start;
        this.usernameCliente = usernameCliente;
    }



    public String getUsernameCliente() {
        return usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
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

    public int getNumGuest() {
        return numGuest;
    }

    public void setNumGuest(int numGuest) {
        this.numGuest = numGuest;
    }

    public String getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(String dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
