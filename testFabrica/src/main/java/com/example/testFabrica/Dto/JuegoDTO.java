package com.example.testFabrica.Dto;

public class JuegoDTO {
    
	private Integer id;
	private String titulo;
	private Integer anio;
	private String protagonistas;
	private String director;
	private String productor;
	private String tecnologia;
	private Boolean estado;
	private Integer precio;
	
	public JuegoDTO(Integer id, String titulo, Integer anio, String protagonistas, String director,
			String productor, String tecnologia, Boolean estado, Integer precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anio = anio;
		this.protagonistas = protagonistas;
		this.director = director;
		this.productor = productor;
		this.tecnologia = tecnologia;
		this.estado = estado;
		this.precio = precio;
	}
	
	
	public JuegoDTO() {super();}
	
	public JuegoDTO(Integer id, Integer precio) {
		super();
		this.id = id;
		this.precio = precio;
	}

	public Integer getIdJuego() {
		return id;
	}
	public void setIdJuego(Integer id) {
		this.id = id;
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
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	
}
