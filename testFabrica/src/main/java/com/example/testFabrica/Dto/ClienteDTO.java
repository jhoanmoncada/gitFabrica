package com.example.testFabrica.Dto;

public class ClienteDTO {
	
	private Integer id;
	private String nombre;
	private String documento;
	private String correo;
	private String telefono;
	private String direccion;
	
	public ClienteDTO(Integer idCliente, String nombre, String documento, String correo, String telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	public ClienteDTO() {super();}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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
