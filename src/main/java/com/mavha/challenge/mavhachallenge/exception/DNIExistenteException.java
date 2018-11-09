package com.mavha.challenge.mavhachallenge.exception;

@SuppressWarnings("serial")
public class DNIExistenteException extends RuntimeException {

	public DNIExistenteException(Long dni) {
		super("El DNI " + dni + " ya existe en la base de datos");
	}

}
