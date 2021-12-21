package com.example.testFabrica.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Juego {
	@Column(name = "id_juego")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer idJuego;
	
	private String titulo;
	private Integer anio;
	private String protagonistas;
	private String director;
	private String productor;
	private String tecnologia;
	private Boolean estado;
	private Integer precio;
	
	@ManyToOne()
	@JoinColumn(name="id_alquiler")
	@JsonBackReference
	private Alquiler alquiler;
	
	public Juego(String titulo, Integer anio, String protagonistas, String director, String productor,
			String tecnologia, Integer precio, Boolean estado) {
		super();
		this.titulo = titulo;
		this.anio = anio;
		this.protagonistas = protagonistas;
		this.director = director;
		this.productor = productor;
		this.tecnologia = tecnologia;
		this.precio = precio;
		this.estado=estado;
	}
	
	public Juego() {
		super();
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public Integer getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getProtagonistas() {
		return protagonistas;
	}

	public void setProtagonistas(String protagonistas) {
		this.protagonistas = protagonistas;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
}
