package com.mavha.challenge.mavhachallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mavha.challenge.mavhachallenge.exception.DNIExistenteException;

@ControllerAdvice
public class PersonaControllerAdvice {

	@ResponseBody
	@ExceptionHandler(DNIExistenteException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	String dniExistenteExceptionHandler(final DNIExistenteException ex) {
		return ex.getMessage();
	}

}
