package com.proyecto.clinica.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.clinica.modelos.Analitica;
import com.proyecto.clinica.repository.IAnaliticaRepo;
import com.proyecto.clinica.repository.IGenericRepo;
import com.proyecto.clinica.servicio.IAnaliticaServicio;

@Service
public class AnaliticaServicioImpl extends CRUDImpl<Analitica, Integer> implements IAnaliticaServicio {

	@Autowired
	IAnaliticaRepo repo;

	@Override
	protected IGenericRepo<Analitica, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
