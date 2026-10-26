package com.mx.ProyectoGamer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ProyectoGamer.entity.VideoJuego;
import com.mx.ProyectoGamer.repository.GeneroRepository;
import com.mx.ProyectoGamer.repository.VideoJuegoRepository;

@Service
public class VideoJuegoService {
	
	

	    @Autowired
	    private VideoJuegoRepository videoJuegoRepository;

	    @Autowired
	    private GeneroRepository generoRepository;

	    // MOSTRAR
	    public List<VideoJuego> mostrar() {
	        return videoJuegoRepository.findAll();
	    }

	    // GUARDAR (Validar nombre no repetido y que ID_CATEGORIA exista)
	    public String guardar(VideoJuego videoJuego) {
	        Optional<VideoJuego> existente = videoJuegoRepository.findByNombre(videoJuego.getNombre());
	        if (existente.isPresent()) {
	            return "Error: El nombre del videojuego ya existe.";
	        }
	        if (!generoRepository.existsById(videoJuego.getGenero().getIdCategoria())) {
	            return "Error: La categoría ingresada no existe en la base de datos.";
	        }
	        videoJuegoRepository.save(videoJuego);
	        return "Videojuego guardado con éxito.";
	    }

	    // BUSCAR POR ID
	    public VideoJuego buscarPorId(Long id) {
	        return videoJuegoRepository.findById(id).orElse(null);
	    }

	    // EDITAR (Validar que ID_VIDEO exista y ID_CATEGORIA exista)
	    public String editar(Long id, VideoJuego videoJuego) {
	        if (!videoJuegoRepository.existsById(id)) {
	            return "Error: El ID del videojuego no existe.";
	        }
	        if (!generoRepository.existsById(videoJuego.getGenero().getIdCategoria())) {
	            return "Error: La categoría ingresada no existe.";
	        }
	        videoJuego.setIdVideo(id);
	        videoJuegoRepository.save(videoJuego);
	        return "Videojuego actualizado con éxito.";
	    }

	    // ELIMINAR (Directo, sin validación previa en BD)
	    public void eliminar(Long id) {
	        videoJuegoRepository.deleteById(id);
	    }
	}


