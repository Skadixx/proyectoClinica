package com.proyecto.clinica.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PacienteDTO {

	private Integer idPaciente;

	@NotEmpty
	@Size(min = 3, message = "{nombres.size}")
	private String nombres;

	/**
	 * "defaultMessage": "{nombres.size}", "objectName": "pacienteDTO", "field":
	 * "nombres", "rejectedValue": "a", "bindingFailure": false, "code": "Size"
	 * 
	 * ERROR QUE TE DA EN POSTMAN POR PONER UN NOMBRE MENOS QUE 3
	 */

	@NotEmpty
	@Size(min = 3, message = "{apellidos.size}")
	private String apellidos;

	@Size(min = 8)
	private String dni;

	@Size(min = 3, max = 150)
	private String direccion;

	@Size(min = 9, max = 9)
	private String telefono;

	@Email
	private String email;

	public PacienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
