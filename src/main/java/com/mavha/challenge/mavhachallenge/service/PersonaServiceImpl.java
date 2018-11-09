package com.mavha.challenge.mavhachallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mavha.challenge.mavhachallenge.exception.DNIExistenteException;
import com.mavha.challenge.mavhachallenge.model.Persona;
import com.mavha.challenge.mavhachallenge.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository repo;
	
	@Override
	public Persona altaPersona(Persona p) {
		Optional<Persona> findById = repo.findById(p.getDni());
		if (findById.isPresent()) {
			throw new DNIExistenteException(p.getDni());
		}
		
		return repo.save(p);
	}

	@Override
	public List<Persona> obtenerPersonasConFiltroOpcional(Optional<Long> dni, Optional<String> nombre, Optional<Integer> edad) {
		return repo.findAll(Example.of(construirFiltroPersona(dni, nombre, edad)));
	}

	private static Persona construirFiltroPersona(Optional<Long> dni, Optional<String> nombre, Optional<Integer> edad) {
		Long nullableDNI = dni.isPresent() ? dni.get() : null;
		String nullableNombre = nombre.isPresent() ? nombre.get() : null;
		Integer nullableEdad = edad.isPresent() ? edad.get() : null;

		return new Persona(nullableDNI, nullableNombre, null, nullableEdad);
	}

}
