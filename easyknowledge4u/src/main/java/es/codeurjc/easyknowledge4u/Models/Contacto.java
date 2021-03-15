package es.codeurjc.easyknowledge4u.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Contacto {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String correo;
	private String texto;
	
	public Contacto() {}
	public Contacto(String nombre, String correo, String texto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.texto = texto;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getTexto(String texto) {
		return texto;
	}

}
