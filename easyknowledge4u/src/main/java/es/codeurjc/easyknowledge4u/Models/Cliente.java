package es.codeurjc.easyknowledge4u.Models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String correo;
	private String password;
	private String direccion;
	@OneToMany(cascade=CascadeType.ALL)
	private List <Cursos> cursos;
	
	public Cliente() {}
	public Cliente(String nombre, String correo, String password,String direccion, Cursos cursos) {
		super();
		this.cursos = new ArrayList<Cursos>();
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.direccion = direccion;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void añadirCurso(Cursos c) {
		
		this.cursos.add(c);
		
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + 
				", correo=" + correo + ", password=" + password + 
				", direccion=" + direccion  + ", Cursos=" 
				+ cursos + "]";
	}

}
