package it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Service;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Model.CustomClienteDetails;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Model.JwtInsertCliente;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Cliente;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomClienteDetailsService implements UserDetailsService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente createCliente(JwtInsertCliente jwtInsertCliente){
        Cliente newCliente = new Cliente();
        newCliente.setNome(jwtInsertCliente.getNome());
        newCliente.setCognome(jwtInsertCliente.getCognome());
        newCliente.setCitta(jwtInsertCliente.getCitta());
        newCliente.setEmail(jwtInsertCliente.getEmail());
        newCliente.setUsername(jwtInsertCliente.getUsername());
        newCliente.setPassword(new BCryptPasswordEncoder().encode(jwtInsertCliente.getPassword()));
        newCliente.setRol(jwtInsertCliente.getRol());
        return clienteRepository.save(newCliente);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         final Cliente user= this.clienteRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomClienteDetails(user);
    }
}
