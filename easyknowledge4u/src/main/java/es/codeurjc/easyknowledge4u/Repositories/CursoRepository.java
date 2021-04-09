package es.codeurjc.easyknowledge4u.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.easyknowledge4u.Models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	

}