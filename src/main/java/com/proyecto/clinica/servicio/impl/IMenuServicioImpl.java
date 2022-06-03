package com.proyecto.clinica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.clinica.modelos.Menu;
import com.proyecto.clinica.repository.IGenericRepo;
import com.proyecto.clinica.repository.IMenuRepo;
import com.proyecto.clinica.servicio.IMenuService;

@Service
public class IMenuServicioImpl extends CRUDImpl<Menu, Integer> implements IMenuService {

	@Autowired
	private IMenuRepo repo;

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		// TODO Auto-generated method stub
		return repo.listarMenuPorUsuario(nombre);
	}

	@Override
	protected IGenericRepo<Menu, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
