package com.proyecto.clinica.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.clinica.dto.PacienteDTO;
import com.proyecto.clinica.exception.ModeloNotFoundException;
import com.proyecto.clinica.modelos.Paciente;
import com.proyecto.clinica.servicio.IPacienteServicio;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteControlador {
	// url normalmente sustantivo en plural

	// no se repiten url en crud porque

	@Autowired
	private IPacienteServicio servicio;

	@Autowired
	private ModelMapper mapper;

//	@GetMapping
//	public List<Paciente> listar() throws Exception {
//		return servicio.listar();
//	}

//	@GetMapping
//	public ResponseEntity<List<Paciente>> listar() throws Exception {
//		return new ResponseEntity<>(servicio.listar(), HttpStatus.OK);
//	}

	@GetMapping
	public ResponseEntity<List<PacienteDTO>> listar() throws Exception {
		List<PacienteDTO> lista = servicio.listar().stream().map(x -> mapper.map(x, PacienteDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	// ==========================================================================================

//	@GetMapping("/{id}")
//	public Paciente listarPorId(@PathVariable Integer id) throws Exception {
//		return servicio.listarPorId(id);
//	}

//	@GetMapping("/{id}")
//	public ResponseEntity<Paciente> listarPorId(@PathVariable Integer id) throws Exception {
//		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
//	}
	// SI LLEVARA DIAMANTES ESTARÍA TIPADO EN OBJECT Y NOSOTROS NO QUEREMOS ESO

//	@GetMapping("/{id}")
//	public ResponseEntity<PacienteDTO> listarPorId(@PathVariable Integer id) throws Exception {
//		Paciente objeto = servicio.listarPorId(id);
//
//		PacienteDTO pacientedto = mapper.map(objeto, PacienteDTO.class);
//		return new ResponseEntity<>(pacientedto, HttpStatus.OK);
//	}

	// SI NO EXISTE EL OBJETO EN LA BASE DE DATOS RETORNARÁ UNA EXCEPCIÓN
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> listarPorId(@PathVariable Integer id) throws Exception {
		Paciente objeto = servicio.listarPorId(id);

		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		PacienteDTO pacientedto = mapper.map(objeto, PacienteDTO.class);
		return new ResponseEntity<>(pacientedto, HttpStatus.OK);
	}

	@GetMapping("/hateoas/{id}")
	public EntityModel<PacienteDTO> listarHateoas(@PathVariable Integer id) throws Exception {
		Paciente objeto = servicio.listarPorId(id);

		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		PacienteDTO pacientedto = mapper.map(objeto, PacienteDTO.class);

		EntityModel<PacienteDTO> recurso = EntityModel.of(pacientedto);

		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));

		recurso.add(link1.withRel("paciente-link"));

		return recurso;
	}

	// ==========================================================================================

//	@PostMapping
//	public Paciente registrar(@RequestBody Paciente p) throws Exception {
//		return servicio.registrar(p);
//	}

//	@PostMapping
//	public ResponseEntity<Paciente> registrar(@RequestBody Paciente p) throws Exception {
//		return new ResponseEntity<>(servicio.registrar(p), HttpStatus.CREATED);
//	}

	@PostMapping
	public ResponseEntity<PacienteDTO> registrar(@Valid @RequestBody PacienteDTO p) throws Exception {
		Paciente objeto = mapper.map(p, Paciente.class);
		Paciente obj = servicio.registrar(objeto);

		PacienteDTO dtoResponse = mapper.map(servicio.registrar(objeto), PacienteDTO.class);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdPaciente()).toUri();

		return ResponseEntity.created(location).build();
	}

	// ==========================================================================================

//	@PutMapping
//	public Paciente modificar(@RequestBody Paciente p) throws Exception {
//		return servicio.modificar(p);
//	}

//	@PutMapping
//	public ResponseEntity<Paciente> modificar(@RequestBody Paciente p) throws Exception {
//		return new ResponseEntity<>(servicio.modificar(p), HttpStatus.OK);
//	}

	@PutMapping
	public ResponseEntity<PacienteDTO> modificar(@Valid @RequestBody PacienteDTO p) throws Exception {

		Paciente pacienteRequest = mapper.map(p, Paciente.class);
		Paciente pacienteConsultado = servicio.listarPorId(pacienteRequest.getIdPaciente());

		if (pacienteConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + pacienteRequest.getIdPaciente());
		}

		Paciente BBDD = servicio.modificar(pacienteRequest);
		PacienteDTO dtoResponse = mapper.map(BBDD, PacienteDTO.class);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	// ==========================================================================================

//	@DeleteMapping("/{id}")
//	public void eliminar(@PathVariable Integer id) throws Exception {
//		servicio.eliminar(id);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {

		Paciente objeto = servicio.listarPorId(id);

		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
