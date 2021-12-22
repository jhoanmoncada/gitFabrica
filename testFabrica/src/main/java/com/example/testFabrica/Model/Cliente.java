package com.example.testFabrica.Model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cliente {
	
	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Alquiler>alquilados;
	
	private String nombre;
	private String documento;
	private String correo;
	private String telefono;
	private String direccion;
	
	public Cliente( Integer idCliente,String nombre, String documento, String correo, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.idCliente=idCliente;
	}
	
	public Cliente() {
		super();
	}

	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public List<Alquiler> getAlquilados() {
		return alquilados;
	}

	public void setAlquilados(List<Alquiler> alquilados) {
		this.alquilados = alquilados;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}

