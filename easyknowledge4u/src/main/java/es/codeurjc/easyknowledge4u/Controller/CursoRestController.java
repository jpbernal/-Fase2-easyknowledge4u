package es.codeurjc.easyknowledge4u.Controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.easyknowledge4u.Models.Curso;
import es.codeurjc.easyknowledge4u.Models.cursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {

	@Autowired
	private cursoService service;

	@GetMapping("/")
	public Collection<Curso> getCursos() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable long id) {
		
		Optional<Curso> op = service.findOne(id);
		if(op.isPresent()) {
			Curso curso = op.get();
			return new ResponseEntity<>(curso, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Curso createCurso(@RequestBody Curso curso) {

		service.save(curso);

		return curso;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Curso> updateCurso(@PathVariable long id, @RequestBody Curso updatedCurso) {

		if (service.exist(id)) {
			
			updatedCurso.setId(id);
			service.save(updatedCurso);

			return new ResponseEntity<>(updatedCurso, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Curso> deleteCurso(@PathVariable long id) {

		try {
			service.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}