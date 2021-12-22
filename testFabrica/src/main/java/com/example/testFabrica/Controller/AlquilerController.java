package com.example.testFabrica.Controller;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testFabrica.Utils;
import com.example.testFabrica.Dto.AlquilerDTO;
import com.example.testFabrica.Dto.JuegoDTO;
import com.example.testFabrica.Model.Alquiler;
import com.example.testFabrica.Model.Cliente;
import com.example.testFabrica.Model.Juego;
import com.example.testFabrica.Repository.AlquierRepository;
import com.example.testFabrica.Repository.ClienteRepository;
import com.example.testFabrica.Repository.JuegoRepository;

@RestController
@RequestMapping(path="alquiler")
public class AlquilerController {
	
	@Autowired
	private AlquierRepository alquirepo;
	
	@Autowired
	private ClienteRepository cliente;
	
	@Autowired
	private JuegoRepository juegorepo;
	
	//obtener todos los registros
			@GetMapping(path="/todosAlquileres")
			public @ResponseBody Map<String,Object> listarJuegos(){
				List <Alquiler> alquiler=new ArrayList<Alquiler>();
				try {
					alquiler=alquirepo.findAll();
					if(alquiler.size()==0) {
						return Utils.respuesta(false, "No existen registros", alquiler);
					}
					return Utils.respuesta(true,"Registros encontrados", alquiler);
				}catch(Exception e) {
					return Utils.respuesta(false, "Error al obtener los registros", null);
				}
			}
			
			//registrar un alquiler
			@PostMapping(path="/registrarAlquiler")
			public @ResponseBody Map<String, Object> registrarJuego (@RequestBody AlquilerDTO al) {
				try {
					
					List<Juego> juegos=new ArrayList<Juego>();
					List<Juego> juegos2=al.getJuegos();
			
					int contador=0;
					int recibidos=juegos2.size();
					if(al.getJuegos()==null||al.getJuegos().size()==0) {
						return Utils.respuesta(false,"Debe ingresar los juegos", null);
					}
					
					for(int i=0;i<recibidos;i++) {
						Optional<Juego> jg=juegorepo.findById(juegos2.get(i).getIdJuego());
						if(jg.isPresent()&&jg.get().getEstado()) {
							juegos.add(jg.get());
							contador++;
						}
					}
					if(contador!=recibidos) {
						return Utils.respuesta(false,"No se encontraron todos los juegos", null);
					}
					
					Optional<Cliente> clien = cliente.findById(al.getIdCliente());
					if(clien.isPresent()) {
						Alquiler alqui=new Alquiler(al.getFechaEntrega(),juegos,clien.get());
						alquirepo.save(alqui);
						
						for(int i=0;i<recibidos;i++) {
							Juego jue=juegos.get(i);
							jue.setEstado(false);
							jue.setAlquiler(alqui);
							juegorepo.save(jue);
						}
						
						return Utils.respuesta(true,"Registro exitoso", alqui);
					}else {
					return Utils.respuesta(false,"El cliente no existe", null);
					}
					
				}catch(Exception e) {
					return Utils.respuesta(false, "Error al registrar: "+e, null);
				}
			}
			
			
			//buscar un venta por fecha
			@GetMapping(path="/buscarCliente/{fecha}")
			public @ResponseBody Map<String,Object> listarCliente(@PathVariable String fecha){
				try {
					List <Alquiler> alquiler=new ArrayList<Alquiler>();
					alquiler=alquirepo.findAll();
					
					List <Alquiler> alquiler2=new ArrayList<Alquiler>();
					if(alquiler==null||alquiler.size()==0) {
						return Utils.respuesta(false, "No existen registros de alquileres", null);
					}
					SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
					Date date=sdformat.parse(fecha);
					for(int i=0;i<alquiler.size();i++) {
						Date date2=sdformat.parse(alquiler.get(i).getFechaPrestamo().toString());
						if(date2.compareTo(date)==0) {
							alquiler2.add(alquiler.get(i));
						}
					}
					
					if(alquiler2.size()>0) {
						return Utils.respuesta(false, "Registros encontrados", alquiler2);
					}
					
					return Utils.respuesta(false, "No existen registros", null);
				}catch(Exception e) {
					return Utils.respuesta(false, "Error al obtener los registros", null);
				}
			}

}
