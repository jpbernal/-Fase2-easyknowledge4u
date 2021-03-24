package es.codeurjc.easyknowledge4u.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		
		//public
		
		//private
		
		
		//login
		
		//logout
		
		
		//CSRF
		
	http.csrf().disable();
	
	}

}
