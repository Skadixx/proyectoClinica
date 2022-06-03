package com.proyecto.clinica.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EspecialidadDTO {

	private Integer idEspecialidades;

	@NotNull
	@Size(min = 3)
	private String descripcion;

	@NotNull
	@Size(min = 3)
	private String nombre;

	public EspecialidadDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdEspecialidades() {
		return idEspecialidades;
	}

	public void setIdEspecialidades(Integer idEspecialidades) {
		this.idEspecialidades = idEspecialidades;
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
