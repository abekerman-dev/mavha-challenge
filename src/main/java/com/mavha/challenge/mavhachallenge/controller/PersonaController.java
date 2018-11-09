package com.mavha.challenge.mavhachallenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mavha.challenge.mavhachallenge.model.Persona;
import com.mavha.challenge.mavhachallenge.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaService service;

	@PostMapping
	Persona altaPersona(@RequestBody Persona p) {
		return service.altaPersona(p);
	}

	@GetMapping
	List<Persona> obtenerPersonasConFiltroOpcional(@RequestParam Optional<Long> dni,
			@RequestParam Optional<String> nombre, @RequestParam Optional<Integer> edad) {
		return service.obtenerPersonasConFiltroOpcional(dni, nombre, edad);
	}

}
