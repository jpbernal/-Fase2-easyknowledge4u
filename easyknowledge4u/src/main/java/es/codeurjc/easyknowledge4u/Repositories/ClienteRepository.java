package es.codeurjc.easyknowledge4u.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.easyknowledge4u.Models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByCorreo(String correo);

}