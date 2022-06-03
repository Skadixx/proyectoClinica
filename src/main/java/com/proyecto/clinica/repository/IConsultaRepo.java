package com.proyecto.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.proyecto.clinica.modelos.Consulta;

public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {

	// nativeQuery es que es propio de sql la sentencia
	@Query(value = "select * from TABLA_CONSULTASPORDIA() ", nativeQuery = true)
	List<Object[]> getConsultas();
	// Dependiendo del usuario nos va a devolver una lista del menu

}
