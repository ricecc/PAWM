package it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Service;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Model.JwtInsertPrenotazione;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Prenotazione;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomPrenotazioneDetailsService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public Prenotazione createPrenotazione(JwtInsertPrenotazione jwtInsertPrenotazione){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setNome(jwtInsertPrenotazione.getNome());
        prenotazione.setNumGuest(jwtInsertPrenotazione.getNumGuest());
        prenotazione.setStart(jwtInsertPrenotazione.getStart());
        prenotazione.setUsernameCliente(jwtInsertPrenotazione.getUsernameCliente());
        prenotazione.setDataPrenotazione(jwtInsertPrenotazione.getDataPrenotazione());
        prenotazione.setNomeRistorante(jwtInsertPrenotazione.getNomeRistorante());
        return this.prenotazioneRepository.save(prenotazione);
    }
}
