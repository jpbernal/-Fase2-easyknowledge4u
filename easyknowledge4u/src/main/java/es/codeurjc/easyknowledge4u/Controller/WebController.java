package es.codeurjc.easyknowledge4u.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import es.codeurjc.easyknowledge4u.Models.*;
import es.codeurjc.easyknowledge4u.Repositories.*;

@Controller
public class WebController {
	
	@SuppressWarnings("unused")
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContactoRepository contactoRepository;
	@SuppressWarnings("unused")
	@Autowired
	private CursoRepository cursosRepository;
	
	
	
	@Autowired
	private cursoService service;
	
	@Autowired
	private UserComponent userComponent;

	@ModelAttribute
	public void addAttributes(Model model) {
		
		boolean logged = userComponent.getLoggedUser() != null;
		
		model.addAttribute("logged", logged);
		model.addAttribute("notLogged", !logged);
		
		if(logged){
			model.addAttribute("userName",userComponent.getLoggedUser().getName());
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
		}
	}
	
	
	@GetMapping("/")
	public String mostrarCursos(Model model) {

		model.addAttribute("cursos", service.findAll());
		
		return "cursos";
	}
	
	
	@GetMapping("/cursos/{id}")
	public String mostrarCurso(Model model, @PathVariable long id) {
		
		Optional <Curso> op = service.findOne(id);
		if(op.isPresent()) {
			Curso curso = op.get();
			model.addAttribute("curso", curso);
			return "curso";
		}else {
			return "cursos";
		}
		
	}
	
	@GetMapping("/removecurso/{id}")
	public String removeCurso(Model model, @PathVariable long id) {
		
		Optional<Curso> op = service.findOne(id);
		if(op.isPresent()) {
			Curso curso = op.get();
			service.delete(id);
			model.addAttribute("curso", curso);
			return "removedcurso";
		}else {
			return "removedcurso";
		}
		
	}
	
	@GetMapping("/newcurso")
	public String newCurso(Model model) {
		
		return "newCursoPage";
	}
	
	@PostMapping("/newcurso")
	public String newCursoProcess(Curso curso) {
		
		
		service.save(curso);
		
		return "cursoCreado";
	}
	@GetMapping("/editcurso/{id}")
	public String editCurso(Model model, @PathVariable long id) {
		
		Optional<Curso> op = service.findOne(id);
		if(op.isPresent()) {
			Curso curso = op.get();
			model.addAttribute("curso", curso);
			return "editCursoPage";
		}else {
			return "cursos";
		}
		
	}
	
	@PostMapping("/editcurso")
	public String editCursoProcess(Curso curso) {
		
		
		service.save(curso);
		
		return "cursoEditado";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {

		return "login";
	}

	@RequestMapping("/loginerror")
	public String loginerror(Model model) {
		return "loginerror";
	}
	
	@RequestMapping("/contacto")
	public String Contacto (Model model) {

		return "contacto";
	}

	@RequestMapping("/guardarContacto")
	public String guardarContacto (Model model, @RequestParam String name, 
		    @RequestParam String email, 
		    @RequestParam String text) {

		        model.addAttribute("Nombre", name);
		        model.addAttribute("Email", email);
		        model.addAttribute("Texto", text);

		        Contacto contactoprueba = new Contacto (name, email, text);
		        contactoRepository.save(contactoprueba);
		
		return "guardarContacto";
	}

}

