package it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Cliente;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Prenotazione;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.comments.CommentLine;

import java.util.List;


@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    public Cliente findByUsername(String username);





}
