package com.mx.ProyectoGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ProyectoGamer.entity.Genero;
import com.mx.ProyectoGamer.service.GeneroService;

@RestController
@RequestMapping("/api/genero")
@CrossOrigin(origins = "*")
public class GeneroController {
	
	@Autowired
    private GeneroService generoService;
	
	//Mostrar todos (GET):
	// http://localhost:8080/api/genero/mostrar
    @GetMapping("/mostrar")
    public List<Genero> mostrar() {
        return generoService.mostrar();
    }

    //Guardar género (POST):
    // http://localhost:8080/api/genero/guardar
    @PostMapping("/guardar")
    public String guardar(@RequestBody Genero genero) {
        return generoService.guardar(genero);
    }

    //Buscar por ID (GET):
    // http://localhost:8080/api/genero/buscar/{id}
    	//(Ejemplo: http://localhost:8080/api/genero/buscar/1
    @GetMapping("/buscar/{id}")
    public Genero buscarPorId(@PathVariable("id") Long id) {
        return generoService.buscarPorId(id);
    }

    //Editar por ID (PUT):
    // http://localhost:8080/api/genero/editar/{id} 
    	// (Ejemplo: http://localhost:8080/api/genero/editar/1
    @PutMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, @RequestBody Genero genero) {
        return generoService.editar(id, genero);
    }

    //Eliminar por ID (DELETE):
    // http://localhost:8080/api/genero/eliminar/{id} 
    	//(Ejemplo: http://localhost:8080/api/genero/eliminar/1
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        generoService.eliminar(id);
        return "Género eliminado con éxito.";
    }

}
