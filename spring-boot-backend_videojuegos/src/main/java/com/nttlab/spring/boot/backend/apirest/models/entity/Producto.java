package com.nttlab.spring.boot.backend.apirest.models.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import javax.validation.constraints.Size;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Column(name="desarrollador", nullable = false)
	@Size(min = 2, max = 50)
	private String desarrollador;
	
	@Column(name="precio", nullable = false)
	private int precio;
	
	@Column(name="stock", nullable = false)
	private int stock;
	
	@Column(name="plataforma", nullable = false)
	@Size(min = 2, max = 50)
	private String plataforma;
	
	@Column(name="descripcion", nullable = false)
	@Size(max = 3000)
	private String descripcion;
	
	//iso 639-1
	
	@Column(name="idioma", nullable = false)
	@Size(min = 2, max = 2)
	private String idioma;
	
	@Column(name="pg", nullable = false)
	@Size(max = 4)
	private String pg;
	
	@Column(name="ano_lanz", nullable = false)
	@Size(min = 1, max = 4)
	private String anolanzamiento;

	@Column(name="urlvideo",nullable=true)
	private String urlvideo;
	
	@Lob
	@Column(name="imagen",columnDefinition="BLOB", nullable=true)
	private String imagen;

	public Producto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getAnolanzamiento() {
		return anolanzamiento;
	}

	public void setAnolanzamiento(String anoLanzamiento) {
		this.anolanzamiento = anoLanzamiento;
	}

	public String getUrlvideo() {
		return urlvideo;
	}

	public void setUrlvideo(String urlvideo) {
		this.urlvideo = urlvideo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
