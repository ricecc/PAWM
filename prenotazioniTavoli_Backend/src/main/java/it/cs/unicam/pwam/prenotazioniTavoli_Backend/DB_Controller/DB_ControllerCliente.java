package it.cs.unicam.pwam.prenotazioniTavoli_Backend.DB_Controller;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.exception.ResourceNotFoundException;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Cliente;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Ristorante;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository.ClienteRepository;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository.RistornateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class DB_ControllerCliente {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RistornateRepository ristornateRepository;

    @PostMapping("/newcliente")
    public Cliente createCliente(@RequestBody Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    //Get cliente by username  restApi
    @GetMapping("/getCliente/{username}")
    public ResponseEntity<Cliente> getClienteByUsername(@PathVariable String username){
        return ResponseEntity.ok(this.clienteRepository.findByUsername(username));
    }

    //update cliente restApi
    @PutMapping("/updatecliente/{id}")
    public ResponseEntity<Cliente> updatePrenotazione(@PathVariable Long id, @RequestBody Cliente clienteDetails){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prenotazione not exist with id: " + id));
        cliente.setNome(clienteDetails.getNome());
        cliente.setCognome(clienteDetails.getCognome());
        cliente.setEmail(clienteDetails.getEmail());

        Cliente updateCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updateCliente);
    }




    //delete cliente restAPI
    @DeleteMapping("/deletecliente/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not exist with id :" + id));
        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
