package com.mx.ProyectoGamer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "VIDEO_JUEGOS")
public class VideoJuego {
	
	@ManyToOne
	@JoinColumn(name = "id_categoria") // O el nombre de tu columna de llave foránea en Oracle
	private Genero genero;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIDEO_JUEGOS")
    @SequenceGenerator(name = "SEQ_VIDEO_JUEGOS", sequenceName = "SEQ_VIDEO_JUEGOS", allocationSize = 1)
    @Column(name = "ID_VIDEO")
    private Long idVideo;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "PRECIO")
    private Double precio;
    
   // @Column(name = "ID_CATEGORIA")
   // private Long idCategoria;

    // Getters y Setters
    public Long getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Long idVideo) {
        this.idVideo = idVideo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
