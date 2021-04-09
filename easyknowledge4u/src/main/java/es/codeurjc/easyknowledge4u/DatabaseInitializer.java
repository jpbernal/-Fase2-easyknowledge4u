package es.codeurjc.easyknowledge4u;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.codeurjc.easyknowledge4u.Models.*;
import es.codeurjc.easyknowledge4u.Repositories.*;

@Component
public class DatabaseInitializer {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {

		// Sample books

		cursoRepository.save(new Curso ("Matemáticas", 230)); // curso ejemplo matematicas
		cursoRepository.save(new Curso ("Inglés", 200)); // curso ingles
		cursoRepository.save(new Curso ("Informática", 190)); //curso informatica
		
		
		// Sample users

		userRepository.save(new User("user@gmail.com", "pass", "ROLE_USER"));
		userRepository.save(new User("admin@gmail.com", "adminpass", "ROLE_USER", "ROLE_ADMIN"));
	}

}
