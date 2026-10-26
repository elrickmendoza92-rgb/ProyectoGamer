package com.mx.ProyectoGamer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProyectoGamer.entity.VideoJuego;

public interface VideoJuegoRepository extends JpaRepository<VideoJuego, Long>{
	
	//Metodo para validar que el nombre de videojuego no se repita
	Optional<VideoJuego> findByNombre(String nombre);

}
