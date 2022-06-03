package com.proyecto.clinica.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.clinica.dto.ConsultaResumenDTO;
import com.proyecto.clinica.servicio.IConsultaServicio;

@RestController
@RequestMapping("/consulta")
public class ConsultaControlador {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IConsultaServicio service;

	@GetMapping
	public ResponseEntity<List<ConsultaResumenDTO>> listar() throws Exception {
		List<ConsultaResumenDTO> lista = service.getConsultas();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
