package it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Controller;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Config.JwtTokenUtil;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Model.*;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Service.CustomClienteDetailsService;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.JWT_Service.CustomPrenotazioneDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins ="*" )
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomClienteDetailsService customClienteDetailsService;

    @Autowired
    private CustomPrenotazioneDetailsService customPrenotazioneDetailsService;

    @RequestMapping(value="/tokenLogin", method = RequestMethod.POST)
    public ResponseEntity<?> generateLoginToken(@RequestBody JwtRequestLogin jwtRequestLogin) throws Exception {
        System.out.println("Inside Controller");
        System.out.println(jwtRequestLogin);
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestLogin.getUsername(), jwtRequestLogin.getPassword()));
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }catch(BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad credetials");
        }
        //fine area
        UserDetails userDetails = this.customClienteDetailsService.loadUserByUsername(jwtRequestLogin.getUsername());

        String token = this.jwtTokenUtil.generateToken(userDetails);
        String username = this.jwtTokenUtil.extractUsername(token);
        System.out.println("JWT"+token);
        return ResponseEntity.ok(new JwtResponse(token,username));
    }

    @RequestMapping(value = "/tokenInsertCliente", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody JwtInsertCliente jwtInsertCliente) throws Exception {
        return ResponseEntity.ok(customClienteDetailsService.createCliente(jwtInsertCliente));
    }

    @RequestMapping(value = "/tokenInsertPrenotazione", method = RequestMethod.POST)
    public ResponseEntity<?> savePrenotazione(@RequestBody JwtInsertPrenotazione jwtInsertPrenotazione) throws Exception {
        return ResponseEntity.ok(customPrenotazioneDetailsService.createPrenotazione(jwtInsertPrenotazione));
    }

    @RequestMapping(value = "/getUsernameByToken", method = RequestMethod.POST)
    public ResponseEntity<?> getUsernameByToken(@RequestBody JwtRequestToken token) throws Exception {
        String getToken = token.getToken();
        String username = this.jwtTokenUtil.extractUsername(getToken);
        return ResponseEntity.ok(new JwtResponse(getToken,username));
    }



}
