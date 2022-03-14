package com.fullapp.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fullapp.springboot.backend.apirest.models.entity.Cliente;

//Data access Object <clase,ID>
public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	//Si queremos añadir nuestros propios metodos a mayores de los de CRUDRepository recordar anotar @Transactional

}
