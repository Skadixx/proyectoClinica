package com.proyecto.clinica.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ModeloNotFoundException(String mensaje) {
		// TODO Auto-generated constructor stub
		super(mensaje);
	}

}
