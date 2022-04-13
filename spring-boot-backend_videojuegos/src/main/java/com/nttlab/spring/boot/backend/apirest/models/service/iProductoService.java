package com.nttlab.spring.boot.backend.apirest.models.service;

import java.util.List;


import com.nttlab.spring.boot.backend.apirest.models.entity.Producto;

public interface iProductoService {
	
	public List <Producto> findAll();
	public Producto save (Producto producto);
	public void delete (Long id);
	public Producto findById(Long id);
	public List<Producto> findByNombre(String nombre);
	public List<Producto> findByPlataforma(String plataforma);
	public List<Producto> findbyLetras(String letra);
	
	
	
	
	
	

}
