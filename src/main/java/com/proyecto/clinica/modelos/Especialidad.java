package com.proyecto.clinica.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidades")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidades;

	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	// Geetters & Setters
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
