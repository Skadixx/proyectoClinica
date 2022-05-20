package com.proyecto.clinica.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

	// Atributos
	private LocalDateTime fecha;
	private String mensaje;
	private String detalles;

	// Constructor vacio
	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	// Constructor con parámetros
	public ExceptionResponse(LocalDateTime fecha, String mensaje, String detalles) {
		super();
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

	// GETTERS AND SETTERS

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

}
