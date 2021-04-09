package es.codeurjc.easyknowledge4u.Models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.easyknowledge4u.Repositories.CursoRepository;


@Service
public class cursoService {

	@Autowired
	private CursoRepository repository;

	public Optional<Curso> findOne(long id) {
		return repository.findById(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Curso> findAll() {
		return repository.findAll();
	}

	public void save(Curso curso) {
		repository.save(curso);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
