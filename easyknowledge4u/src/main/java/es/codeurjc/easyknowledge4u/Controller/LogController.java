package es.codeurjc.easyknowledge4u.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.classic.Logger;

public class LogController {

	private Logger log = (Logger) LoggerFactory.getLogger(LogController.class);
	
	@GetMapping("/page_log")
	public String page(Model model) {
		
		
		log.trace("Trace message");
		log.debug("Debug message");
		log.info("Info message");
		log.error("ErrOr message");
		return "page";
	}
}
