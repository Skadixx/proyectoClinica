package com.proyecto.clinica.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnaliticaDTO {

	private Integer idAnalitica;

	@NotNull
	@Size(min = 3)
	private String descripcion;

	@NotNull
	@Size(min = 3)
	private String nombre;

	public AnaliticaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdAnalitica() {
		return idAnalitica;
	}

	public void setIdAnalitica(Integer idAnalitica) {
		this.idAnalitica = idAnalitica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
