package it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Cliente;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Ristorante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ristoranteRepository")
public interface RistornateRepository extends JpaRepository<Ristorante,Long> {

    @Query(value="SELECT * FROM ristorante r WHERE r.città=?1", nativeQuery = true)
    public List<Ristorante> getResturantByCity(String citta);

    @Query(value="SELECT * FROM ristorante r WHERE r.nome_ristorante=?1", nativeQuery = true)
    public Ristorante findByNomeRistorante(String nome);
}
