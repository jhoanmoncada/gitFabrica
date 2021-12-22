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
import com.example.testFabrica.Model.Cliente;
import com.example.testFabrica.Repository.ClienteRepository;

@RestController
@RequestMapping(path="cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository cliente;
	
	//obtener todos los registros
	@GetMapping(path="/todosClientes")
	public @ResponseBody Map<String,Object> listarClientes(){
		List <Cliente> clientes=new ArrayList<Cliente>();
		try {
			clientes=cliente.findAll();
			if(clientes.size()==0) {
				return Utils.respuesta(false, "No existen registros", null);
			}
			return Utils.respuesta(true,"Registros encontrados", clientes);
			
		}catch(Exception e) {
			return Utils.respuesta(false, "Error al obtener los registros", null);
		}
	}
	
	
	//buscar un cliente por id
	@GetMapping(path="/buscarCliente/{id}")
	public @ResponseBody Map<String,Object> listarCliente(@PathVariable Integer id){
		try {
			Optional<Cliente> clien = cliente.findById(id);
			if(clien.isPresent()) {
				Cliente cl=clien.get();
				return Utils.respuesta(true, "Registro encontrado", cl);
			}
			return Utils.respuesta(false, "Registro no encontrado", null);
		}catch(Exception e) {
			return Utils.respuesta(false, "Error al obtener los registros", null);
		}
	}
	
	//registrar un cliente
	@PostMapping(path="/registrarCliente")
	public @ResponseBody Map<String, Object> registrarCliente (@RequestBody ClienteDTO cl) {
		try {
			Cliente cli=new Cliente(null,cl.getNombre(),cl.getDocumento(),cl.getCorreo(),cl.getTelefono(),cl.getDireccion());
			cliente.save(cli);
			return Utils.respuesta(true,"Registro exitoso", cli);
		}catch(Exception e) {
			return Utils.respuesta(false, "Error al registrar", null);
		}
	}
	
	
	//actualizar un cliente
		@PutMapping(path="/actualizarCliente")
		public @ResponseBody Map<String, Object> actualizarCliente (@RequestBody ClienteDTO cl) {
			try {
				Optional<Cliente> clien = cliente.findById(cl.getId());
				if(clien.isPresent()) {
					
					Cliente cl2=clien.get();
					if(!cl.getNombre().isBlank()) {
						cl2.setNombre(cl.getNombre());
					}
					if(!cl.getCorreo().isBlank()) {
						cl2.setCorreo(cl.getCorreo());
					}
					if(!cl.getDireccion().isBlank()) {
						cl2.setDireccion(cl.getDireccion());
					}
					if(!cl.getDocumento().isBlank()) {
						cl2.setDocumento(cl.getDocumento());
					}
					if(!cl.getTelefono().isBlank()) {
						cl2.setTelefono(cl.getTelefono());
					}
					cliente.save(cl2);
					return Utils.respuesta(true,"Registro actualizado", cl2);
				}
				return Utils.respuesta(false,"Registro no encontrado", null);
			}catch(Exception e) {
				return Utils.respuesta(false, "Error al modificar: "+e.getMessage(), null);
			}
		}
	
	
		//eliminar un cliente por id
		@DeleteMapping(path="/eliminarCliente/{id}")
		public @ResponseBody Map<String,Object> eliminarCliente(@PathVariable Integer id){
			try {
				Optional<Cliente> clien = cliente.findById(id);
				if(clien.isPresent()) {
					cliente.delete(clien.get());
					return Utils.respuesta(true, "Registro eliminado", clien);
				}
				return Utils.respuesta(false, "Registro no encontrado", null);
			}catch(Exception e) {
				return Utils.respuesta(false, "Error al eliminar el registro", null);
			}
		}
		
	
}
