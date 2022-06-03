package com.proyecto.clinica.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "consulta_examen")
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {

	@Id
	private Consulta consulta;

	@Id
	private Analitica analitica;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Analitica getExamen() {
		return analitica;
	}

	public void setExamen(Analitica analitica) {
		this.analitica = analitica;
	}

}
