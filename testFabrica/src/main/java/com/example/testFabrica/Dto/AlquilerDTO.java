package com.example.testFabrica.Dto;

import java.util.Date;
import java.util.List;

import com.example.testFabrica.Model.Cliente;
import com.example.testFabrica.Model.Juego;

public class AlquilerDTO {
	
	private List<Juego>juegos;
	private Date fechaEntrega;
	private Integer idCliente;
	public AlquilerDTO(List<Juego> juegos, Date fechaEntrega, Integer idCliente) {
		super();
		this.juegos = juegos;
		this.fechaEntrega = fechaEntrega;
		this.idCliente = idCliente;
	}
	public AlquilerDTO() {
		super();
	}
	public List<Juego> getJuegos() {
		return juegos;
	}
	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
