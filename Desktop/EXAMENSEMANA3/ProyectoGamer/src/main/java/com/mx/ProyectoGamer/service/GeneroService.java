package com.mx.ProyectoGamer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ProyectoGamer.entity.Genero;
import com.mx.ProyectoGamer.repository.GeneroRepository;


@Service
public class GeneroService {
	
	@Autowired
    private GeneroRepository generoRepository;

    // MOSTRAR
    public List<Genero> mostrar() {
        return generoRepository.findAll();
    }

    // GUARDAR (Validar que el nombre no se repita)
    public String guardar(Genero genero) {
        Optional<Genero> existente = generoRepository.findByNombre(genero.getNombre());
        if (existente.isPresent()) {
            return "Error: El nombre del género ya existe.";
        }
        generoRepository.save(genero);
        return "Género guardado con éxito.";
    }

    // BUSCAR POR ID
    public Genero buscarPorId(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    // EDITAR (Validar que el ID exista para poder editar)
    public String editar(Long id, Genero genero) {
        if (generoRepository.existsById(id)) {
            genero.setIdCategoria(id);
            generoRepository.save(genero);
            return "Género actualizado con éxito.";
        }
        return "Error: El ID de la categoría no existe.";
    }

    // ELIMINAR (Directo, sin validación previa en BD como se menciona)
    public void eliminar(Long id) {
        generoRepository.deleteById(id);
    }

}
