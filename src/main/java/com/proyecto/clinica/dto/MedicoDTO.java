package com.proyecto.clinica.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MedicoDTO {

	// solo@NotNull
	private Integer idMedico;

	@NotEmpty
	private String nombres;

	/**
	 * "defaultMessage": "{nombres.size}", "objectName": "pacienteDTO", "field":
	 * "nombres", "rejectedValue": "a", "bindingFailure": false, "code": "Size"
	 * 
	 * ERROR QUE TE DA EN POSTMAN POR PONER UN NOMBRE MENOS QUE 3
	 */
	@NotNull
	private String apellidos;

	@NotNull
	private String cedula;

	@NotNull
	private String fotoUrl;

	public MedicoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

}
