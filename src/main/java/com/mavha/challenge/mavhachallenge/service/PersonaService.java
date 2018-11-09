package com.mavha.challenge.mavhachallenge.service;

import java.util.List;
import java.util.Optional;

import com.mavha.challenge.mavhachallenge.model.Persona;

public interface PersonaService {

	/**
	 * Devuelve una lista de personas aplicando los filtros que se le pasen, que son
	 * opcionales
	 * 
	 * @param dni
	 * @param nombre
	 * @param edad
	 * @return
	 */
	List<Persona> obtenerPersonasConFiltroOpcional(Optional<Long> dni, Optional<String> nombre, Optional<Integer> edad);
	
	Persona altaPersona(Persona p);

}
