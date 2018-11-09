package com.mavha.challenge.mavhachallenge.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mavha.challenge.mavhachallenge.exception.DNIExistenteException;
import com.mavha.challenge.mavhachallenge.model.Persona;
import com.mavha.challenge.mavhachallenge.service.PersonaService;

/**
 * Test case de PersonaServiceImpl que considera casos felices y casos de
 * excepción. No mockea el repositorio sino que usa los propios datos de inicio
 * de la aplicación Spring.
 * 
 * En una aplicación productiva de verdad, el repositorio del service debería
 * ser mockeado con los datos que se generan al inicio de esta aplicación,
 * generando el mismo resultado en los casos de prueba.
 * 
 * @author andres
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonaServiceTest {

	private static final Long DNI_EXISTENTE = 11222333L;
	private static final Long DNI_INEXISTENTE = 99999999L;

	private static final String NOMBRE_IMPOSIBLE_DE_ENCONTRAR = "nombreimposibledeencontrar";
	private static final String JUAN = "Juan";

	private static final Integer EDAD_CINCUENTA = 50;

	@Autowired
	private PersonaService service;

	@Test
	public void altaPersonaConDNIInexistenteDevuelvePersona() {
		Persona personaNueva = service.altaPersona(new Persona(DNI_INEXISTENTE, "Persona", "De Prueba", 100));
		assertEquals(DNI_INEXISTENTE, personaNueva.getDni());
	}

	@Test(expected = DNIExistenteException.class)
	public void altaPersonaConDNIExistenteDevuelveExcepcion() {
		service.altaPersona(new Persona(DNI_EXISTENTE, "Persona", "De Prueba", 100));
	}

	@Test
	public void listadoPersonasSinFiltroDevuelveListaDeTodasLasPersonas() {
		final List<Persona> todasLasPersonas = service.obtenerPersonasConFiltroOpcional(Optional.empty(),
				Optional.empty(), Optional.empty());
		assertEquals(3, todasLasPersonas.size());
	}

	@Test
	public void listadoPersonasConFiltroDNIInexistenteDevuelveListaVacia() {
		final List<Persona> listaVacia = service.obtenerPersonasConFiltroOpcional(Optional.of(DNI_INEXISTENTE),
				Optional.empty(), Optional.empty());
		assertTrue(listaVacia.isEmpty());
	}

	@Test
	public void listadoPersonasConFiltroDNIExistenteDevuelvePersonaConEseDNI() {
		final List<Persona> listaConUnaPersona = service.obtenerPersonasConFiltroOpcional(Optional.of(DNI_EXISTENTE),
				Optional.empty(), Optional.empty());
		assertEquals(1, listaConUnaPersona.size());
		assertEquals(DNI_EXISTENTE, listaConUnaPersona.get(0)
				.getDni());
	}

	@Test
	public void listadoPersonasConFiltroNombreInexistenteDevuelveListaVacia() {
		final List<Persona> listaVacia = service.obtenerPersonasConFiltroOpcional(Optional.empty(),
				Optional.of(NOMBRE_IMPOSIBLE_DE_ENCONTRAR), Optional.empty());
		assertTrue(listaVacia.isEmpty());
	}

	@Test
	public void listadoPersonasConFiltroNombreExistenteDevuelvePersonasConEseNombre() {
		final List<Persona> listaConUnaPersona = service.obtenerPersonasConFiltroOpcional(Optional.empty(),
				Optional.of(JUAN), Optional.empty());
		assertEquals(2, listaConUnaPersona.size());
		assertEquals(JUAN, listaConUnaPersona.get(0)
				.getNombre());
	}

	@Test
	public void listadoPersonasConFiltroEdadInexistenteDevuelveListaVacia() {
		final List<Persona> listaVacia = service.obtenerPersonasConFiltroOpcional(Optional.empty(), Optional.empty(),
				Optional.of(-1));
		assertTrue(listaVacia.isEmpty());
	}

	@Test
	public void listadoPersonasConFiltroEdadExistenteDevuelvePersonasConEsaEdad() {
		final List<Persona> listaConUnaPersona = service.obtenerPersonasConFiltroOpcional(Optional.empty(),
				Optional.empty(), Optional.of(EDAD_CINCUENTA));
		assertEquals(1, listaConUnaPersona.size());
		assertEquals(EDAD_CINCUENTA, listaConUnaPersona.get(0)
				.getEdad());
	}

}
