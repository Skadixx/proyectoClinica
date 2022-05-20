package com.proyecto.clinica.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.clinica.modelos.Paciente;
import com.proyecto.clinica.repository.IGenericRepo;
import com.proyecto.clinica.repository.IPacienteRepo;
import com.proyecto.clinica.servicio.IPacienteServicio;

@Service
public class PacienteServicioImpl extends CRUDImpl<Paciente, Integer> implements IPacienteServicio {

	// Obtenemos el bean de paciente y se lo p
	@Autowired
	private IPacienteRepo repoPaciente;

	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repoPaciente;
	}
}
