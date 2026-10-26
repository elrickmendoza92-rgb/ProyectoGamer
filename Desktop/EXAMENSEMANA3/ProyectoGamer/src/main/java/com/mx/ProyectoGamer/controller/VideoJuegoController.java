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

import com.mx.ProyectoGamer.entity.VideoJuego;
import com.mx.ProyectoGamer.service.VideoJuegoService;

@RestController
@RequestMapping("/api/videojuego")
@CrossOrigin(origins = "*")
public class VideoJuegoController {
	
	@Autowired
    private VideoJuegoService videoJuegoService;
	

	//Mostrar todos (GET):
	// http://localhost:8080/api/videojuego/mostrar
    @GetMapping("/mostrar")
    public List<VideoJuego> mostrar() {
        return videoJuegoService.mostrar();
    }

    //Guardar videojuego (POST):
    //http://localhost:8080/api/videojuego/guardar
    @PostMapping("/guardar")
    public String guardar(@RequestBody VideoJuego videoJuego) {
        return videoJuegoService.guardar(videoJuego);
    }

    //Buscar por ID (GET):
    // http//localhost:8080/api/videojuego/buscar/{id} 
    	//(Ejemplo: http://localhost:8080/api/videojuego/buscar/1)
    @GetMapping("/buscar/{id}")
    public VideoJuego buscarPorId(@PathVariable("id") Long id) {
        return videoJuegoService.buscarPorId(id);
    }

    //Editar por ID (PUT):
    //http:localhost:8080/api/videojuego/editar/{id}
    	//(Ejemplo: http://localhost:8080/api/videojuego/editar/1)
    @PutMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, @RequestBody VideoJuego videoJuego) {
        return videoJuegoService.editar(id, videoJuego);
    }

    //Eliminar por ID (DELETE):
    //http:localhost:8080/api/videojuego/eliminar/{id}
    	//(Ejemplo: http://localhost:8080/api/videojuego/eliminar/1)
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        videoJuegoService.eliminar(id);
        return "Videojuego eliminado con éxito.";
    }

}
