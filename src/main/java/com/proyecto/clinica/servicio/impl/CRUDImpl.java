package com.proyecto.clinica.servicio.impl;

import java.util.List;
import java.util.Optional;

import com.proyecto.clinica.repository.IGenericRepo;

public abstract class CRUDImpl<T, ID> {

	/**
	 * lo unico que no podemos inicializar es este metodo porque en cada servicio
	 * necesitaremos instanciarlo para decirle cual es el repo que utilizaremos
	 */
	protected abstract IGenericRepo<T, ID> getRepo();

	/**
	 * 
	 * @param t LA CLASE PACIENTE O MEDICO EN ESTE CASO
	 * @return DICHA CLASE (MODELO(TABLA DE LA BASE DE DATOS))
	 * @throws Exception
	 */
	public T registrar(T t) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	public T modificar(T t) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	public List<T> listar() throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	public T listarPorId(ID id) throws Exception {
		// TODO Auto-generated method stub
		Optional<T> t1 = getRepo().findById(id);
		return t1.isPresent() ? t1.get() : null;
	}

	public void eliminar(ID id) throws Exception {
		// TODO Auto-generated method stub
		getRepo().deleteById(id);
	}
}
