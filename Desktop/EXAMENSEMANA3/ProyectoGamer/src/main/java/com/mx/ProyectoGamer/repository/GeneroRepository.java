package com.mx.ProyectoGamer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProyectoGamer.entity.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long>{
	
	//Metodo para validar que el nombre del genero no se repita
	Optional<Genero> findByNombre(String nombre);

}
