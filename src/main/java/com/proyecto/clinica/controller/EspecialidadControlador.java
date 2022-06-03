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

import com.proyecto.clinica.dto.EspecialidadDTO;
import com.proyecto.clinica.exception.ModeloNotFoundException;
import com.proyecto.clinica.modelos.Especialidad;
import com.proyecto.clinica.servicio.IEspecialidadServicio;

@RestController
@RequestMapping("/especialidad")
//@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadControlador {

	@Autowired
	private IEspecialidadServicio servicio;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<EspecialidadDTO>> listar() throws Exception {
		List<EspecialidadDTO> listaEspecialidad = servicio.listar().stream()
				.map(x -> mapper.map(x, EspecialidadDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(listaEspecialidad, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EspecialidadDTO> listarPorId(@PathVariable Integer id) throws Exception {
		Especialidad especialidad = servicio.listarPorId(id);

		if (especialidad == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		EspecialidadDTO especialidaddto = mapper.map(especialidad, EspecialidadDTO.class);
		return new ResponseEntity<>(especialidaddto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EspecialidadDTO> registrar(@Valid @RequestBody EspecialidadDTO e) throws Exception {
		Especialidad especialidadmap = mapper.map(e, Especialidad.class);

		EspecialidadDTO dtoResponse = mapper.map(servicio.registrar(especialidadmap), EspecialidadDTO.class);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdEspecialidades()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<EspecialidadDTO> modificar(@Valid @RequestBody EspecialidadDTO e) throws Exception {
		Especialidad especialidadRequest = mapper.map(e, Especialidad.class);
		Especialidad especialidadConsultado = servicio.listarPorId(especialidadRequest.getIdEspecialidades());

		if (especialidadConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + especialidadRequest.getIdEspecialidades());
		}

		Especialidad BBDD = servicio.modificar(especialidadRequest);
		EspecialidadDTO dtoResponse = mapper.map(BBDD, EspecialidadDTO.class);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {
		Especialidad especialidad = servicio.listarPorId(id);

		if (especialidad == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
