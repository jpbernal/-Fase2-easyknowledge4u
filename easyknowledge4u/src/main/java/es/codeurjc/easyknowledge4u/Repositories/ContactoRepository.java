package es.codeurjc.easyknowledge4u.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.easyknowledge4u.Models.Contacto;


public interface ContactoRepository extends JpaRepository<Contacto, Long>{
	
	
}