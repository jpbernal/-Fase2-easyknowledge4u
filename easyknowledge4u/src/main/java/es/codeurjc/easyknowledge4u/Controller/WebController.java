package es.codeurjc.easyknowledge4u.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.easyknowledge4u.Repositories.ClienteRepository;

@Controller
public class WebController {
	
	@Autowired
	private ClienteRepository clientes;
	
	@GetMapping("/index")
	public String Index (Model model) {
		
		return "index";
		
	}

	@GetMapping("/login")
	public String Login(Model model) {
		
		return "login";
	}
	
	@GetMapping("/register")
	public String Register(Model model) {
		return "register";
	}
	
	@GetMapping("/contact")
	public String Contacto(Model model) {
		
		return "contact";
	}
	
	
	@RequestMapping("/registro")
	public String Registro(Model model, @RequestParam String Nombre, 
			@RequestParam String Email, 
			@RequestParam String Contraseña) {
		model.addAttribute("nombre", Nombre);
		model.addAttribute("email", Email);
		model.addAttribute("password", Contraseña);
		return "registro";
	
	}	
}
