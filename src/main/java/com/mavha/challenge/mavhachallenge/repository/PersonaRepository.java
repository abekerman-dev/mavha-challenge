package com.mavha.challenge.mavhachallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mavha.challenge.mavhachallenge.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
