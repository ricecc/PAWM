package it.cs.unicam.pwam.prenotazioniTavoli_Backend.DB_Controller;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.exception.ResourceNotFoundException;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Prenotazione;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class DB_ControllerPrenotazione {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    //create nuova prenotazione
    @PostMapping("/newprenotazione")
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione){
        return this.prenotazioneRepository.save(prenotazione);
    }

    @GetMapping("/allprenotazioni")
    public List<Prenotazione> getAllPrenotazioni(){
        return this.prenotazioneRepository.findAll();
    }

    //Get prenotazione by id prenotazione restApi
    @GetMapping("/prenotazione/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id){
        Prenotazione prenotazione = prenotazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        return ResponseEntity.ok(prenotazione);
    }

    //Get prenotazioni by username cliente restApi
    @GetMapping("/prenotazioni/cliente/{username}")
    public List<Prenotazione> getAllPrenotazioniByIdCliente(@PathVariable String username){
      return prenotazioneRepository.getAllPrenotazioniByUsernameCliente(username);
    }

    //update prenotazione restApi
    @PutMapping("/updateprenotazione/{id}")
    public ResponseEntity<Prenotazione> updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazioneDetails){
        Prenotazione prenotazione = prenotazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prenotazione not exist with id: " + id));
        prenotazione.setNome(prenotazioneDetails.getNome());
        prenotazione.setNumGuest(prenotazioneDetails.getNumGuest());
        prenotazione.setDataPrenotazione(prenotazioneDetails.getDataPrenotazione());
        prenotazione.setStart(prenotazioneDetails.getStart());
        Prenotazione updatePrenotazione = prenotazioneRepository.save(prenotazione);
        return ResponseEntity.ok(updatePrenotazione);
    }
    //delete prenotazione restAPI
    @DeleteMapping("/deleteprenotazione/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePrenotazione(@PathVariable Long id){
        Prenotazione prenotazione = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prenotazione not exist with id :" + id));
        prenotazioneRepository.delete(prenotazione);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
