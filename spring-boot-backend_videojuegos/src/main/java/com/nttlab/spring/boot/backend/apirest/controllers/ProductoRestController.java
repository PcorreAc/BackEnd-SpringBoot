package com.nttlab.spring.boot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nttlab.spring.boot.backend.apirest.models.entity.Producto;
import com.nttlab.spring.boot.backend.apirest.models.service.iProductoService;

@CrossOrigin(origins = "*", allowedHeaders = "*") //CORS cross-origin resource sharing
@RestController
@RequestMapping(value = "/api")
public class ProductoRestController {
	/***************************************************
	 * API REST PARA EL MANEJO DE PRODUCTOS
	 * 	@author	Pablo Correa, Hector Ulloa, Milton Vargas, Byron Bravo
		@version 1.0.0
		@see	Interfaz iProductoService, Interfaz iProductoDAO, Clase Producto
	 * 
	 * ************************************************/
	
	@Autowired
	private iProductoService productoService;
	
	//FUNCIONES PARA ENVIAR POR REQUEST LISTAS DE USUARIOS SEGUN VARIOS PARAMETROS
	
	@GetMapping(value = "/productos", produces ="application/json")
	public ResponseEntity<?> showAll(){
		List<Producto> productos = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			productos = productoService.findAll();
		} catch(DataAccessException  ex) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		if(productos.size() == 0) {
			response.put("mensaje", "No existen productos");
			response.put("empleados", productos);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "Actualmente la base de datos cuenta con: " + productos.size() + " registros");
		response.put("productos", productos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	
		
	}
	
	@GetMapping(value = "/productos/{id}", produces = "application/json")
	public ResponseEntity<?> showOne(@PathVariable Long id){
		Producto producto =  null;
		Map<String, Object> response = new HashMap<>();
		try {
			producto = productoService.findById(id);
		}
		catch(DataAccessException ex) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(producto == null) {
			response.put("mensaje", " Producto: " + id + " no existe en nuestros registros. revise");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/productos/nombre/{nombre}", produces = "application/json")
	public ResponseEntity<?> showByNombre(@PathVariable String nombre){
		Map<String, Object> response = new HashMap<>();
		List<Producto> productosPorNombre = null;
		try {
			productosPorNombre = productoService.findByNombre(nombre);
			
		}catch(DataAccessException  ex) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		if(productosPorNombre.size() == 0) {
			response.put("mensaje", "No existen productos");
			response.put("productos", productosPorNombre);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("productos", productosPorNombre);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	
	}
	
	
	@GetMapping(value = "/productos/plataforma/{plataforma}", produces = "application/json")
	public ResponseEntity<?> showByPlataforma(@PathVariable String plataforma){
		Map<String, Object> response = new HashMap<>();
		List<Producto> productosPorPlataforma = null;
		try {
			productosPorPlataforma = productoService.findByPlataforma(plataforma);
			
		}catch(DataAccessException  ex) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(productosPorPlataforma.size() == 0) {
			response.put("mensaje", "No existen productos");
			response.put("productos", productosPorPlataforma);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("productos", productosPorPlataforma);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	
	}
	
	
	@GetMapping(value = "/productos/letra/{letra}", produces = "application/json")
	public ResponseEntity<?> showByLetras(@PathVariable String letra){
		Map<String, Object> response = new HashMap<>();
		List<Producto> productosPorLetra = null;
		try {
			productosPorLetra = productoService.findbyLetras(letra);
			
		}catch(DataAccessException  ex) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(productosPorLetra.size() == 0) {
			response.put("mensaje", "No existen productos");
			response.put("productos", productosPorLetra);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("productos", productosPorLetra);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	
	}
	
	
	//METODOS PARA CRUD 
	
	@PostMapping(value="/productos", produces ="application/json")
	public ResponseEntity<?> create(@RequestBody Producto producto){
		Producto productoNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			//buscar poductos en la lista, si el nombre y
			//la plataforma son iguales, el juego no se puede guardar
			List<Producto> productos = productoService.findAll();
			
			for(Producto p : productos) {
				if(p.getNombre().equalsIgnoreCase(producto.getNombre()) 
						&& p.getPlataforma().equalsIgnoreCase(producto.getPlataforma()) ) {
					response.put("Mensaje","Error al registrar un nuevo producto, el producto existe para la plataforma designada");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
			}
			productoNuevo = productoService.save(producto);
			
		} catch(ConstraintViolationException | DataAccessException ex) {
			response.put("mensaje", "Error al realizar el proceso de registro de un nuevo producto.");
			response.put("error", ex.getMessage() + ": " +ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Producto creado exitosamente");
		response.put("producto", productoNuevo);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);		
	
	}
	
	
	@PutMapping(value="/productos/{id}", produces ="application/json")
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id){
		Producto productoActual = productoService.findById(id);
		Producto productoActualizado = null;
		Map<String, Object> response = new HashMap<>();
		if(productoActual == null) {
			response.put("mensaje", "No se puede editar. El producto ID: " + id + " no se encuentra en nuestros registros.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			productoActual.setNombre(producto.getNombre());
			productoActual.setDesarrollador(producto.getDesarrollador());
			productoActual.setPrecio(producto.getPrecio());
			productoActual.setStock(producto.getStock());
			productoActual.setPlataforma(producto.getPlataforma());
			productoActual.setDescripcion(producto.getDescripcion());
			productoActual.setIdioma(producto.getIdioma());
			productoActual.setPg(producto.getPg());
			productoActual.setAnolanzamiento(producto.getAnolanzamiento());
			productoActual.setUrlvideo(producto.getUrlvideo());
			productoActual.setImagen(producto.getImagen());
			
			productoActualizado = productoService.save(productoActual);
			
		} catch(ConstraintViolationException | DataAccessException ex) {
			response.put("mensaje", "Error al realizar la actualizacion del producto.");
			response.put("error", ex.getMessage() + ": " +ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "Producto actualizado exitosamente");
		response.put("producto", productoActualizado);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }
	
	@DeleteMapping(value = "/productos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			productoService.delete(id);
		}
		catch(DataAccessException ex) {
			response.put("mensaje", "Error al eliminar Producto de la base de datos.");
			response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Producto eliminado exitosamente!!!!!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	

}
