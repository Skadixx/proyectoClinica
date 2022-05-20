package com.proyecto.clinica.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.clinica.modelos.Medico;
import com.proyecto.clinica.repository.IGenericRepo;
import com.proyecto.clinica.repository.IMedicoRepo;
import com.proyecto.clinica.servicio.IMedicoServicio;

@Service
public class MedicoServicioImpl extends CRUDImpl<Medico, Integer> implements IMedicoServicio {

	@Autowired
	private IMedicoRepo repoMedico;
	// me pide que haga la clase abstract o implemente los métodos del jpa

	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repoMedico;
	}

}
