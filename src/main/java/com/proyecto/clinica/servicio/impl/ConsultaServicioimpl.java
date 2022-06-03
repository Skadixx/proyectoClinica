package com.proyecto.clinica.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.clinica.dto.ConsultaResumenDTO;
import com.proyecto.clinica.modelos.Consulta;
import com.proyecto.clinica.repository.IConsultaRepo;
import com.proyecto.clinica.repository.IGenericRepo;
import com.proyecto.clinica.servicio.IConsultaServicio;

@Service
public class ConsultaServicioimpl extends CRUDImpl<Consulta, Integer> implements IConsultaServicio {

	@Autowired
	IConsultaRepo repo;

	@Override
	protected IGenericRepo<Consulta, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<ConsultaResumenDTO> getConsultas() {

		List<ConsultaResumenDTO> consultas = new ArrayList<>();

		repo.getConsultas().forEach(x -> {
			ConsultaResumenDTO cr = new ConsultaResumenDTO();

			cr.setFecha(String.valueOf(x[0]));
			cr.setCantidad(Integer.parseInt(String.valueOf(x[1])));

			consultas.add(cr);

		});

		return consultas;

	}

}
