package es.codeurjc.easyknowledge4u.Models;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import es.codeurjc.easyknowledge4u.Repositories.UserRepository;

@Component
public class DataBaseUsersLoader {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	
	private void initDataBase() {
		
		userRepository.save( new User ("user", "pass", "ROLE_USER"));
		userRepository.save( new User ("admin", "adminpass","ROLE_ADMIN"));
		
		
	}

}
