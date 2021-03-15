package es.codeurjc.easyknowledge4u.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

import es.codeurjc.easyknowledge4u.Models.*;
import es.codeurjc.easyknowledge4u.Repositories.*;

@Controller
public class WebController {
	
	@Autowired
	private ClienteRepository cliente;
	@Autowired
	private ContactoRepository contacto;
	@Autowired
	private CursoRepository cursos;
	
	
	
	@PostConstruct
    public void init() {
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
	@RequestParam String correo,
	@RequestParam String password) {
		boolean check = false;
		Cliente prueba = cliente.findByCorreo(correo);
		if(prueba != null && prueba.getPassword().equals(password)) check = true;
		model.addAttribute("comprobarLogin",check);
		model.addAttribute("Correo", correo);
		
		return "inicio-sesion";
	}
		
	@GetMapping("/contacto")
	public String Contacto (Model model) {
		
		return "contacto";
	}
	
	@RequestMapping("/registro")
	public String Registro (Model model, @RequestParam String Nombre, 
	@RequestParam String Email, 
	@RequestParam String Contraseña) {
		
		model.addAttribute("Nombre", Nombre);
		model.addAttribute("Email", Email);
		model.addAttribute("Contraseña", Contraseña);
		
		Cliente prueba = new Cliente(Nombre,Email,Contraseña, null, null);
		cliente.save(prueba);
		
		return "registro";
	}	
	
	@GetMapping("/cursos")
	public String Cursos (Model model) {
		
		return "cursos";
	}
		
	@RequestMapping("/añadirCursoM")
	public String añadirCursoM(Model model,
	@RequestParam String tipoCurso) {
		
		model.addAttribute("Matematicas", tipoCurso);
		Cursos matematicas = new Cursos (null, 230, tipoCurso);
		cursos.save(matematicas);
		
		return "tipo-cursoM";
		
	}
	
	@RequestMapping("/añadirCursoI")
	public String añadirCursoI(Model model,
	@RequestParam String tipoCurso) {
		
		model.addAttribute("Informatica", tipoCurso);
		Cursos informatica = new Cursos (null, 250, tipoCurso);
		cursos.save(informatica);
		
		return "tipo-cursoI";
		
	}
	
	@RequestMapping("/añadirCursoE")
	public String añadirCursoE(Model model,
	@RequestParam String tipoCurso) {
		
		model.addAttribute("Ingles", tipoCurso);
		Cursos ingles = new Cursos (null, 180, tipoCurso);
		cursos.save(ingles);
		
		return "tipo-cursoE";
		
	}
	
	@RequestMapping("/guardarContacto")
	public String guardarContacto (Model model, @RequestParam String Nombre, 
	@RequestParam String Email, 
	@RequestParam String Texto) {
		
		model.addAttribute("Nombre", Nombre);
		model.addAttribute("Email", Email);
		model.addAttribute("Texto", Texto);
		
		Contacto contactoprueba = new Contacto (Nombre, Email, Texto);
		contacto.save(contactoprueba);
		
		return "contacto-enviado";
	
	}
	
}
