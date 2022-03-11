package it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("prenotazioneRepository")
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {

    @Query(value="SELECT * FROM prenotazioni p WHERE p.username_cliente=?1", nativeQuery = true)
     List<Prenotazione> getAllPrenotazioniByUsernameCliente(String usernameCliente);




}
