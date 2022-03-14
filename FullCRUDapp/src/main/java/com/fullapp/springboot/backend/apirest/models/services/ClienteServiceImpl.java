package com.fullapp.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullapp.springboot.backend.apirest.models.dao.IClienteDao;
import com.fullapp.springboot.backend.apirest.models.entity.Cliente;

//Implementamos los metodos del crud repositoy a traves de la interfaz de servicio inyectando la interfaz DAO
@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao; //Instancia Interfaz DAO inyectada
	
	@Override
	@Transactional(readOnly = true) //Anotamos la clase como transaccionable, aunque ya lo son todas las de CRUDRepository pero añadimos readOnly true
	public List<Cliente> findAll() {		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional //readOnly es false por defecto
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);		
	}
	
	

}
