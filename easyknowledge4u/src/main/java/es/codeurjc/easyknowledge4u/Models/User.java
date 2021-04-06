package es.codeurjc.easyknowledge4u.Models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String idUsuario;
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	 private List<String> roles;
	
	public User() {}
	
	public User(String idUsuario, String password, String role1) {
		this.idUsuario=idUsuario;
		this.password=password;
	}
	
	public User(String idUsuario, String password, String role1, String role2) {
		this.idUsuario=idUsuario;
		this.password=password;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}