package com.mavha.challenge.mavhachallenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mavha.challenge.mavhachallenge.model.Persona;
import com.mavha.challenge.mavhachallenge.repository.PersonaRepository;

@Component
class StartupRunner {

	@Bean
	CommandLineRunner runStartupCommand(PersonaRepository repo) {
		return args -> {
			// Inicialización de la base de datos con datos para testear
			repo.save(new Persona(11222333L, "Juan", "Pérez", 40));
			repo.save(new Persona(22333444L, "Juan", "Pérez Reverte", 45));
			repo.save(new Persona(33444555L, "Juana", "Molina", 50));
		};
	}

}