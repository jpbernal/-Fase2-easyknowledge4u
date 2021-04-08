package es.codeurjc.easyknowledge4u.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

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
	@SuppressWarnings("unused")
	@Autowired
	private UserRepository userRepository;
	
	
	
	@PostConstruct
    public void init() {
    }
	
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
	
	
	@GetMapping("/index")
	public String Index (Model model) {
	
		return "index";
	}
	
	@GetMapping("/admin") //acceso credenciales
	
	public String Admin (Model model, HttpServletRequest request) {
		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
	
		return "admin";
	}

	@GetMapping("/login")
	public String Login (Model model) {
		
		return "login";
	}
	@GetMapping("/home")
	public String Home (Model model) {
		
		return "home";
	}
	
	@GetMapping("/adminPanel") //check credenciales
	public String AdminPanel (Model model, 
	@RequestParam String username,
	@RequestParam String password) {
				
		//wip
		
		return "adminPanel";
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
		
		return "registro"; // registrado correctamente
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


