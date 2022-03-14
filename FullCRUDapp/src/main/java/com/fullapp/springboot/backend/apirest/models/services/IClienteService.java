package com.fullapp.springboot.backend.apirest.models.services;

import java.util.List;

import com.fullapp.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService { //Interfaz de servicios con los metodos del CRUD repository

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
}
