package es.codeurjc.easyknowledge4u;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping("/index")
	public String Index (Model model) {
		
		return "index";
		
	}

	@GetMapping("/login")
	public String Login(Model model) {
		
		return "login";
	}
	
	@GetMapping("/contact")
	public String Contacto(Model model) {
		
		return "contact";
	}
	
	
	
}
