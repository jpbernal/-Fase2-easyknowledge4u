package es.codeurjc.items;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @PostMapping("/sendEmail")
	public ResponseEntity<Void> addItem(@RequestBody Message message) {
		System.out.println("Send message: "+message.getMessageText()+" to "+message.getEmail());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
    
}
