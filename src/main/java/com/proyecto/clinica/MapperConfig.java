package com.proyecto.clinica;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	// de versiones anteriores se utilizaba bean ponemos bean porque queremos
	// utilizarlo como tal
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
