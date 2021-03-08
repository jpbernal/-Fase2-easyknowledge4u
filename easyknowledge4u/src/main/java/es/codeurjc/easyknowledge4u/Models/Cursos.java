package es.codeurjc.easyknowledge4u.Models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cursos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade=CascadeType.ALL)
	private Cliente cliente;
	private float coste;
	private String tipoCurso;
	
	public Cursos() {}
	public Cursos(Cliente cliente, float coste, String tipoCurso) {
		super();
		this.cliente = cliente;
		this.coste = coste;
		this.tipoCurso = tipoCurso;
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


	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", cliente=" + cliente + ", coste="
				+ coste + ", tipoCurso=" + tipoCurso + "]";
	}
}