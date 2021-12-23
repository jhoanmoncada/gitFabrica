package com.example.testFabrica.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testFabrica.Utils;
import com.example.testFabrica.Dto.ClienteDTO;
import com.example.testFabrica.Dto.JuegoDTO;
import com.example.testFabrica.Model.Cliente;
import com.example.testFabrica.Model.Juego;
import com.example.testFabrica.Repository.ClienteRepository;
import com.example.testFabrica.Repository.JuegoRepository;

@RestController
@RequestMapping(path="juego")
public class JuegoController {

	@Autowired
	private JuegoRepository juegorepo;
	
	
	//obtener todos los registros
		@GetMapping(path="/todosJuegos")
		public @ResponseBody Map<String,Object> listarJuegos(){
			List <Juego> juegos=new ArrayList<Juego>();
			try {
				juegos=juegorepo.findAll();
				if(juegos.size()==0) {
					return Utils.respuesta(false, "No existen registros", null);
				}
				return Utils.respuesta(true,"Registros encontrados", juegos);
				
			}catch(Exception e) {
				return Utils.respuesta(false, "Error al obtener los registros", null);
			}
		}
		
		//registrar un juego
		@PostMapping(path="/registrarJuego")
		public @ResponseBody Map<String, Object> registrarJuego (@RequestBody JuegoDTO ju) {
			try {
				Juego juego=new Juego(ju.getTitulo(),ju.getAnio(),ju.getProtagonistas(),ju.getDirector(),ju.getProductor(),ju.getTecnologia(),ju.getPrecio(),ju.getEstado());
				juegorepo.save(juego);
				return Utils.respuesta(true,"Registro exitoso", juego);
			}catch(Exception e) {
				return Utils.respuesta(false, "Error al registrar", null);
			}
		}
		
		//actualizar el precio de un juego
				@PutMapping(path="/actualizarPrecioJuego")
				public @ResponseBody Map<String, Object> actualizarPrecioJuego (@RequestBody JuegoDTO ju) {
					try {
						Optional<Juego> jue = juegorepo.findById(ju.getIdJuego());
						if(jue.isPresent()) {
							
							Juego jg2=jue.get();
							if(ju.getPrecio()!=null) {
								jg2.setPrecio(ju.getPrecio());
							}
							juegorepo.save(jg2);
							return Utils.respuesta(true,"Registro actualizado", jg2);
						}
						return Utils.respuesta(false,"Registro no encontrado", null);
					}catch(Exception e) {
						return Utils.respuesta(false, "Error al modificar: "+e.getMessage(), null);
					}
				}
				
		
				//actualizar juego
				@PutMapping(path="/actualizarJuego")
				public @ResponseBody Map<String, Object> actualizarJuego (@RequestBody JuegoDTO ju) {
					try {
						Optional<Juego> jue = juegorepo.findById(ju.getIdJuego());
						if(jue.isPresent()) {
							
							Juego jg2=jue.get();
							if(ju.getPrecio()!=null) {
								jg2.setPrecio(ju.getPrecio());
							}
							if(!ju.getDirector().isBlank()) {
								jg2.setDirector(ju.getDirector());
							}
							if(ju.getEstado()!=null) {
								jg2.setEstado(ju.getEstado());
							}
							if(!ju.getTitulo().isBlank()) {
								jg2.setTitulo(ju.getTitulo());
							}
							if(ju.getAnio()!=null) {
								jg2.setAnio(ju.getAnio());
							}
							if(!ju.getProtagonistas().isBlank()) {
								jg2.setProtagonistas(ju.getProtagonistas());
							}
							if(!ju.getDirector().isBlank()) {
								jg2.setDirector(ju.getDirector());
							}
							if(!ju.getTecnologia().isBlank()) {
								jg2.setTecnologia(ju.getTecnologia());
							}
							jg2.setIdJuego(ju.getIdJuego());
							juegorepo.save(jg2);
							return Utils.respuesta(true,"Registro actualizado", jg2);
							
						}
						
						return Utils.respuesta(false,"Registro no encontrado", null);
						
					}catch(Exception e) {
						
						return Utils.respuesta(false, "Error al modificar: "+e.getMessage(), null);
						
					}
				}
				
				//eliminar un juego por id
				@DeleteMapping(path="/eliminarJuego/{id}")
				public @ResponseBody Map<String,Object> eliminarCliente(@PathVariable Integer id){
					try {
						Optional<Juego> jue = juegorepo.findById(id);
						if(jue.isPresent()) {
							juegorepo.delete(jue.get());
							return Utils.respuesta(true, "Registro eliminado", jue);
						}
						return Utils.respuesta(false, "Registro no encontrado", null);
					}catch(Exception e) {
						return Utils.respuesta(false, "Error al eliminar el registro", null);
					}
				}
}
