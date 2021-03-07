package es.codeurjc.easyknowledge4u.Controller;


import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

import es.codeurjc.easyknowledge4u.Models.*;
import es.codeurjc.easyknowledge4u.Repositories.ClienteRepository;
import es.codeurjc.easyknowledge4u.Repositories.CursoRepository;

@Controller
public class WebController {
	
	@Autowired
	private ClienteRepository cliente;
	@Autowired
	private CursoRepository cursos;
	
	@PostConstruct
    public void init() {
		Cliente prueba = new Cliente ("Nombre", "Correo@gmail.com", "password123", "direccion1", null);
		Cursos cursoPrueba = new Cursos (prueba, 23, "tipo");
		prueba.setCursos(cursoPrueba);
		cliente.save(prueba);
		cursos.save(cursoPrueba);
    }
	
	@GetMapping("/index")
	public String Index (Model model) {
		
		return "index";
		
	}

	@GetMapping("/login")
	public String Login (Model model) {
		
		return "login";
	}
	
	@GetMapping("/register")
	public String Register (Model model) {
		
		return "register";
	}
	
	@RequestMapping("/comprobarLogin")
	public String comprobarLogin(Model model,
			@RequestParam String Nombre,
			@RequestParam String password) {
		boolean check = false;
		Cliente prueba = cliente.findByNombreUsuario(Nombre);
		if(prueba != null && prueba.getPassword().equals(password)) check = true;
		model.addAttribute("IncioSesionCorrecto",check);
		return "inicio-sesion";
	}
	@GetMapping("/contact")
	public String Contacto (Model model) {
		
		return "contact";
	}
	@RequestMapping("/registro")
	public String Registro (Model model, @RequestParam String Nombre, 
			@RequestParam String Email, 
			@RequestParam String Contraseña) {
		model.addAttribute("nombre", Nombre);
		model.addAttribute("email", Email);
		model.addAttribute("password", Contraseña);
		
		Cliente prueba = new Cliente(Nombre,Email,Contraseña, null, null);
		cliente.save(prueba);
		return "registro";
	
	}	
	
}
