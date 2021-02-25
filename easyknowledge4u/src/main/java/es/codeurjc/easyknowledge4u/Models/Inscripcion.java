package es.codeurjc.easyknowledge4u.Models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inscripcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Cliente cliente;
	private Cursos[] cursos;
	private float coste;
	private String fecha;
	
	public Inscripcion() {}

	public Inscripcion(Cliente cliente, Cursos[] cursos, float coste, String fecha) {
		super();
		this.cliente = cliente;
		this.cursos = cursos;
		this.coste = coste;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cursos[] getCursos() {
		return cursos;
	}

	public void setCursos(Cursos[] cursos) {
		this.cursos = cursos;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Inscripcion [id=" + id + ", cliente=" + cliente + ", curso=" + Arrays.toString(cursos) + ", coste="
				+ coste + ", fecha=" + fecha + "]";
	}

}
