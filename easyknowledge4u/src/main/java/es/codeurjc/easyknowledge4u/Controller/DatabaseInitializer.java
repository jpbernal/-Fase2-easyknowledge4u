package es.codeurjc.easyknowledge4u.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.codeurjc.easyknowledge4u.Models.*;
import es.codeurjc.easyknowledge4u.Repositories.*;

@Component
public class DatabaseInitializer {

	@Autowired
	private CursoRepository cursosRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {

		// Sample books

		cursosRepository.save(new Cursos (null, 230, "matematicas")); // curso ejemplo matematicas
		cursosRepository.save(new Cursos (null, 200, "Ingles")); // curso ingles
		cursosRepository.save(new Cursos (null, 180, "informatica")); //curso informatica
		
		
		// Sample users

		userRepository.save(new User("user", "pass", "ROLE_USER"));
		userRepository.save(new User("admin", "pass", "ROLE_USER", "ROLE_ADMIN"));
	}

}
