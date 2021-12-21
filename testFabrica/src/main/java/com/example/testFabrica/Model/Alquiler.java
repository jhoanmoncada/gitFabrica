package com.example.testFabrica.Model;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Alquiler {
	
	@Id
    @Column(name = "id_alquiler")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAlquiler;
	
	@Column(name = "fecha_prestamo", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Timestamp fechaPrestamo;
	
	private Date fechaEntrega;
	
	@OneToMany(mappedBy = "alquiler", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Juego>juegos;
	
	@ManyToOne
	@JoinColumn(name = "cliente", nullable = false, referencedColumnName = "id_cliente")
	@JsonBackReference
	private Cliente cliente;
	
	private Long totalVenta;

	public Alquiler(Date fechaEntrega, List<Juego>juegos,Cliente cliente) {
		super();
		this.fechaEntrega = fechaEntrega;
		this.juegos=juegos;
		this.totalVenta=calcularTotal(juegos);
		this.cliente=cliente;
	}

	public Alquiler() {
		super();
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	public Integer getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Timestamp getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Timestamp fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public Long getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(Long totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	public Long calcularTotal(List<Juego>juegos) {
		Long total=(long) 0;
		for(Juego j: juegos) {
			total+=j.getPrecio();
		}
		
		return total;
	}
	
		
}
