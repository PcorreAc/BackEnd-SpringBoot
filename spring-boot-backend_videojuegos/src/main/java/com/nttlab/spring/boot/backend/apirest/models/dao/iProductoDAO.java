package com.nttlab.spring.boot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nttlab.spring.boot.backend.apirest.models.entity.Producto;



public interface iProductoDAO extends CrudRepository<Producto, Long> {
	
	public List<Producto> findByNombre(String nombre);
	public List<Producto> findByPlataforma(String plataforma);
	@Query(value="select * from Productos p where p.nombre like %:letra% or p.plataforma like %:letra% or p.desarrollador like %:letra% ",nativeQuery = true)
	public List<Producto> findbyLetras(@Param("letra") String letra);

}
