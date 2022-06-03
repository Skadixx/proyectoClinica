package com.proyecto.clinica.servicio;

import java.util.List;

import com.proyecto.clinica.modelos.Menu;

public interface IMenuService extends ICRUD<Menu, Integer> {

	List<Menu> listarMenuPorUsuario(String nombre);
}
