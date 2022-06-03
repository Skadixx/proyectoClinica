package com.proyecto.clinica.servicio;

import java.util.List;

import com.proyecto.clinica.dto.ConsultaResumenDTO;
import com.proyecto.clinica.modelos.Consulta;

public interface IConsultaServicio extends ICRUD<Consulta, Integer> {

//	Consulta guardarTransaccion(Consulta consulta, List<Analiticas> analiticas) throws Exception;
	List<ConsultaResumenDTO> getConsultas();
}
