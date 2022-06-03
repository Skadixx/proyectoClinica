package com.proyecto.clinica.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.clinica.dto.AnaliticaDTO;
import com.proyecto.clinica.exception.ModeloNotFoundException;
import com.proyecto.clinica.modelos.Analitica;
import com.proyecto.clinica.servicio.IAnaliticaServicio;

@RestController
@RequestMapping("/analitica")
//@CrossOrigin(origins = "http://localhost:4200")
public class AnaliticaControlador {

	@Autowired
	private IAnaliticaServicio servicio;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<AnaliticaDTO>> listar() throws Exception {
		List<AnaliticaDTO> listaAnalitica = servicio.listar().stream().map(x -> mapper.map(x, AnaliticaDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(listaAnalitica, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AnaliticaDTO> listarPorId(@PathVariable Integer id) throws Exception {
		Analitica analitica = servicio.listarPorId(id);

		if (analitica == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		AnaliticaDTO analiticadto = mapper.map(analitica, AnaliticaDTO.class);
		return new ResponseEntity<>(analiticadto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AnaliticaDTO> registrar(@Valid @RequestBody AnaliticaDTO a) throws Exception {
		Analitica analiticamap = mapper.map(a, Analitica.class);

		AnaliticaDTO dtoResponse = mapper.map(servicio.registrar(analiticamap), AnaliticaDTO.class);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdAnalitica()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<AnaliticaDTO> modificar(@Valid @RequestBody AnaliticaDTO a) throws Exception {
		Analitica analiticaRequest = mapper.map(a, Analitica.class);
		Analitica analiticaConsultado = servicio.listarPorId(analiticaRequest.getIdAnalitica());

		if (analiticaConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + analiticaRequest.getIdAnalitica());
		}

		Analitica BBDD = servicio.modificar(analiticaRequest);
		AnaliticaDTO dtoResponse = mapper.map(BBDD, AnaliticaDTO.class);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {
		Analitica analitica = servicio.listarPorId(id);

		if (analitica == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
