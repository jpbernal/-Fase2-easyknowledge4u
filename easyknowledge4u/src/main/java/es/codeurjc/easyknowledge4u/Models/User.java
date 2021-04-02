package es.codeurjc.easyknowledge4u.Models;

import java.util.ArrayList;
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
	private Long id;
	private String nombre;
	private String passwordHash;
	
@ElementCollection(fetch = FetchType.EAGER)
private List<String> roles;



public User() {}
public User(String nombre, String passwordHash, String roles) {
	super();
	this.roles = new ArrayList<String>();
	this.nombre = nombre;
	this.passwordHash = passwordHash;

}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getPasswordHash() {
	return passwordHash;
}

public void setPasswordHash(String passwordHash) {
	this.passwordHash = passwordHash;
}

public void añadirRol(String roles) {
	
	this.roles.add(roles);
	
}

}
