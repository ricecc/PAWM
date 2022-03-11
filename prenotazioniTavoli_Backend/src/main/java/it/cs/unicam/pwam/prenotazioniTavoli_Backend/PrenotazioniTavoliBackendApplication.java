package it.cs.unicam.pwam.prenotazioniTavoli_Backend;

import it.cs.unicam.pwam.prenotazioniTavoli_Backend.model.Prenotazione;
import it.cs.unicam.pwam.prenotazioniTavoli_Backend.repository.PrenotazioneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class PrenotazioniTavoliBackendApplication {
	@Bean
	public WebMvcConfigurer configure(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
						.allowedOrigins("http://localhost:4200");
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PrenotazioniTavoliBackendApplication.class, args);


	}

}
