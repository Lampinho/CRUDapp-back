package com.fullapp.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fullapp.springboot.backend.apirest.models.entity.Cliente;
import com.fullapp.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"}) //Restingimos los origenes, metodos http, cabeceras...
@RestController //Anotamos la clase como controlador  ApiRest
@RequestMapping("/api") //Mapeamos todos los metodos del rest a esta url - ENDPOINT
public class ClientRestController {
	
	@Autowired
	private IClienteService clienteService; //Inyectamos instancia de interfaz service
	
	@GetMapping("/clientes") //anotamos el GET de la url para que devuelva el listado de clientes
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) { //anotacion para indicar que el parametro se pasa debe estar enlazado a la variable de la URI-mapping
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")//Los datos los recibimos desde Angular(cliente) en el body en formato JSON
	@ResponseStatus(HttpStatus.CREATED) //Por defecto el resto tendra un OK (200)
	public Cliente create(@RequestBody Cliente cliente) { //Anotacion para pasar de JSON a objeto		
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id);		
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		clienteActual.setNombre(cliente.getNombre());		
		return clienteService.save(clienteActual); //Al coincidir el id save ejecuta un merge	
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
}
