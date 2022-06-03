package com.proyecto.clinica.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.clinica.dto.MenuDTO;
import com.proyecto.clinica.modelos.Menu;
import com.proyecto.clinica.servicio.IMenuService;

@RestController
@RequestMapping("/menu")
public class MenuControlador {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IMenuService service;

	@GetMapping
	public ResponseEntity<List<MenuDTO>> listar() throws Exception {
		List<Menu> menus = new ArrayList<>();
		menus = service.listar();
		List<MenuDTO> menusDTO = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {
		}.getType());
		return new ResponseEntity<>(menusDTO, HttpStatus.OK);
	}

	@PostMapping("/usuario")
	public ResponseEntity<List<MenuDTO>> listar(@RequestBody String nombre) {
		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorUsuario(nombre);
//      para que no se tenga que pasar el usuario por la url:
		// Authentication usuarioLogueado =
		// SecurityContextHolder.getContext().getAuthentication();
		// menus = service.listarMenuPorUsuario(usuarioLogueado.getName());
		List<MenuDTO> menusDto = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {
		}.getType());
		return new ResponseEntity<List<MenuDTO>>(menusDto, HttpStatus.OK);
	}
}
