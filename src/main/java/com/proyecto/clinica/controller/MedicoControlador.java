package com.proyecto.clinica.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.clinica.dto.MedicoDTO;
import com.proyecto.clinica.exception.ModeloNotFoundException;
import com.proyecto.clinica.modelos.Medico;
import com.proyecto.clinica.servicio.IMedicoServicio;

@RestController
@RequestMapping("/medico")
//@CrossOrigin(origins = "http://localhost:4200")
public class MedicoControlador {
	// url normalmente sustantivo en plural

	// no se repiten url en crud porque

	@Autowired
	private IMedicoServicio servicio;

	@Autowired
	private ModelMapper mapper;

	// @PreAuthorize("hasAuthority('ADMIN')")//da permito al rol de administrador
	// or hasAuthority('USER')"

	// si quiero hacer una autorzacion más personalizada entonces defino un servico
	// un método para personalizarlo
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> listar() throws Exception {
		List<MedicoDTO> lista = servicio.listar().stream().map(x -> mapper.map(x, MedicoDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedicoDTO> listarPorId(@PathVariable Integer id) throws Exception {
		Medico objeto = servicio.listarPorId(id);

		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		MedicoDTO medicodto = mapper.map(objeto, MedicoDTO.class);
		return new ResponseEntity<>(medicodto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<MedicoDTO> registrar(@Valid @RequestBody MedicoDTO p) throws Exception {
		Medico objeto = mapper.map(p, Medico.class);
		MedicoDTO dtoResponse = mapper.map(servicio.registrar(objeto), MedicoDTO.class);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdMedico()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<MedicoDTO> modificar(@Valid @RequestBody MedicoDTO m) throws Exception {
		Medico medicoRequest = mapper.map(m, Medico.class);
		Medico medicoConsultado = servicio.listarPorId(medicoRequest.getIdMedico());

		if (medicoConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + medicoRequest.getIdMedico());
		}

		Medico BBDD = servicio.modificar(medicoRequest);
		MedicoDTO dtoResponse = mapper.map(BBDD, MedicoDTO.class);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {
		Medico objeto = servicio.listarPorId(id);

		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
