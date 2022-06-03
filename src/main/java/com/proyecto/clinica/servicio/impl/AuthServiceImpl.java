package com.proyecto.clinica.servicio.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

	// devolvemos verdadero si ese usuario contiene alguno de esos roles
	public boolean tieneAcceso(String path) {

		boolean rpta = false;

		String metodoRol = "";

		switch (path) {
		case "listar":
			metodoRol = "ADMIN";
			break;

		case "listarId":
			metodoRol = "ADMIN,USER,DBA";
			break;
		}

		String metodoRoles[] = metodoRol.split(",");

		// cn esta linea podemos obtener el usuario que está conectado en ese momento
		Authentication usuarioLogueado = SecurityContextHolder.getContext().getAuthentication();

		System.out.println(usuarioLogueado.getName());

		for (GrantedAuthority auth : usuarioLogueado.getAuthorities()) {
			String rolUser = auth.getAuthority();
			System.out.println(rolUser);

			for (String rolMet : metodoRoles) {
				if (rolUser.equalsIgnoreCase(rolMet)) {
					rpta = true;
				}
			}
		}

		return rpta;

	}

}
