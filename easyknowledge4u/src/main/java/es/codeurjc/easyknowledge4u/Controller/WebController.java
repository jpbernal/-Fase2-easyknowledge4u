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
	private ClienteRepository clienteRepository;
	@Autowired
	private ContactoRepository contactoRepository;
	@Autowired
	private CursoRepository cursosRepository;
	
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
		Cliente prueba = clienteRepository.findByCorreo(correo);
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
		clienteRepository.save(prueba);
		
		return "registro";
	}	
	
	@GetMapping("/cursos")
	public String Cursos (Model model) {
		
		return "cursos";
	}
		
	@RequestMapping("/añadirCursoM")
	public String añadirCursoM(Model model, @RequestParam String Nombre) {
		
		Cliente usuario = clienteRepository.findByNombre(Nombre);
		
		if(usuario != null) {
			
			Cursos matematicas = new Cursos (usuario, 230, "matematicas");
			cursosRepository.save(matematicas);
			usuario.añadirCurso(matematicas);
			clienteRepository.saveAndFlush(usuario);
			model.addAttribute("añadirCursoM", true);			
		}	
		return "tipo-cursoM";
	}
	
	@RequestMapping("/añadirCursoI")
	public String añadirCursoI(Model model, @RequestParam String Nombre) {
		
		Cliente usuario = clienteRepository.findByNombre(Nombre);
		
		if(usuario != null) {
			
			Cursos informatica = new Cursos (usuario, 230, "informatica");
			cursosRepository.save(informatica);
			usuario.añadirCurso(informatica);
			clienteRepository.saveAndFlush(usuario);
			model.addAttribute("añadirCursoI", true);
			
		}	
		return "tipo-cursoI";		
	}
	
	@RequestMapping("/añadirCursoE")
	public String añadirCursoE(Model model, @RequestParam String Nombre) {
		
		Cliente usuario = clienteRepository.findByNombre(Nombre);
		
		if(usuario != null) {
			
			Cursos ingles = new Cursos (usuario, 230, "ingles");
			cursosRepository.save(ingles);
			usuario.añadirCurso(ingles);
			clienteRepository.saveAndFlush(usuario);
			model.addAttribute("añadirCursoE", true);			
		}			
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
		contactoRepository.save(contactoprueba);
		
		return "contacto-enviado";	
	}	
}
