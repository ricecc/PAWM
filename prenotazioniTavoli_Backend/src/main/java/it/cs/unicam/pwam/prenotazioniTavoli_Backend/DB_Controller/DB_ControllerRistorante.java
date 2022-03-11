package it.cs.unicam.pwam.prenotazioniTavoli_Backend.DB_Controller;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Cliente;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Ristorante;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository.RistornateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class DB_ControllerRistorante {
    @Autowired
    private RistornateRepository ristornateRepository;

    @GetMapping("/getResturantByCity/{citta}")
    public List<Ristorante> getResturantByCity(@PathVariable String citta){
        return this.ristornateRepository.getResturantByCity(citta);
    }

    @GetMapping("/getRistoranteByNome/{nomeRistorante}")
    public ResponseEntity<Ristorante> getRistoranteByNome(@PathVariable String nomeRistorante){
        return ResponseEntity.ok(this.ristornateRepository.findByNomeRistorante(nomeRistorante));
    }


}
