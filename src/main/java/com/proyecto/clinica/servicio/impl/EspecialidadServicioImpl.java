package com.proyecto.clinica.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.clinica.modelos.Especialidad;
import com.proyecto.clinica.repository.IEspecialidadRepo;
import com.proyecto.clinica.repository.IGenericRepo;
import com.proyecto.clinica.servicio.IEspecialidadServicio;

@Service
public class EspecialidadServicioImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadServicio {

	@Autowired
	IEspecialidadRepo repo;

	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
