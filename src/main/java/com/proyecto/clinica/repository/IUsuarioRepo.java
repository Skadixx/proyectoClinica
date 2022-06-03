package com.proyecto.clinica.repository;

import com.proyecto.clinica.modelos.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer> {

	Usuario findOneByUsername(String nombreUser);
}
