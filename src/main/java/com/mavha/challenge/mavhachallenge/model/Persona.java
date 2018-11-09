package com.mavha.challenge.mavhachallenge.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Persona {

	@Id
	private Long dni;

	private String nombre;

	private String apellido;

	private Integer edad;
	
	public Persona(Long dni, String nombre, String apellido, Integer edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

}
