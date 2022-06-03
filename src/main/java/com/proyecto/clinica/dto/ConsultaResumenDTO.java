package com.proyecto.clinica.dto;

import javax.validation.constraints.NotNull;

public class ConsultaResumenDTO {

	@NotNull
	private Integer cantidad;

	@NotNull
	private String fecha;

	public ConsultaResumenDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
