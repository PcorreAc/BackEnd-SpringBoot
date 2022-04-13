package com.nttlab.spring.boot.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttlab.spring.boot.backend.apirest.models.dao.iProductoDAO;
import com.nttlab.spring.boot.backend.apirest.models.entity.Producto;
@Service
public class ProductoService implements iProductoService{
	
	@Autowired
	private iProductoDAO productoDAO;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDAO.findAll();
	}
	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoDAO.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDAO.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String nombre) {
		return productoDAO.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByPlataforma(String plataforma) {
		return productoDAO.findByPlataforma(plataforma);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findbyLetras(String letra) {
		return productoDAO.findbyLetras(letra);
	}

}
