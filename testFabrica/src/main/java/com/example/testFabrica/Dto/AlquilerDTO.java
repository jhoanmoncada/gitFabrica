package com.example.testFabrica.Dto;

import java.util.Date;
import java.util.List;

import com.example.testFabrica.Model.Cliente;
import com.example.testFabrica.Model.Juego;

public class AlquilerDTO {
	
	private Integer id;
	private List<Juego>juegos;
	private Date fechaEntrega;
	private Integer idCliente;
	private boolean entregado;
	
	public AlquilerDTO(List<Juego> juegos, Date fechaEntrega, Integer idCliente,boolean entregado) {
		super();
		this.juegos = juegos;
		this.fechaEntrega = fechaEntrega;
		this.idCliente = idCliente;
		this.entregado=entregado;
	}
	
	
	public AlquilerDTO(Integer id, boolean entregado) {
		super();
		this.id = id;
		this.entregado = entregado;
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public AlquilerDTO() {
		super();
	}
	
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
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
