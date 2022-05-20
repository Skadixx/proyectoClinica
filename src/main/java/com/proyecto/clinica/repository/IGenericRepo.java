package com.proyecto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T, ID> {

	// heredamos de JpaRepository y tenemos que poer norep
//crea una clase implementada y la pone directamente, crea el bean directamente
}
