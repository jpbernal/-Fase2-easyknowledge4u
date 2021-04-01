package es.codeurjc.easyknowledge4u.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		
		//public
		
		 http.authorizeRequests().antMatchers("/index").permitAll();
		 http.authorizeRequests().antMatchers("/login").permitAll();
		 http.authorizeRequests().antMatchers("/register").permitAll();
		 http.authorizeRequests().antMatchers("/contacto").permitAll();
		 http.authorizeRequests().antMatchers("/comprobarLogin").permitAll();
		 http.authorizeRequests().antMatchers("/registro").permitAll();
		 http.authorizeRequests().antMatchers("/cursos").permitAll();
		 http.authorizeRequests().antMatchers("/añadirCursoM").permitAll();
		 http.authorizeRequests().antMatchers("/guardarContacto").permitAll();
		 
		//private
		 
		 http.authorizeRequests().anyRequest().authenticated();
				
		// Login form
		 http.formLogin().loginPage("/login");
		 http.formLogin().usernameParameter("username");
		 http.formLogin().passwordParameter("password");
		 http.formLogin().defaultSuccessUrl("/home");
		 http.formLogin().failureUrl("/loginerror");
		 // Logout
		 http.logout().logoutUrl("/logout");
		 http.logout().logoutSuccessUrl("/");
		 
		//CSRF
		
	http.csrf().disable();
	
	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 
	 // User 
	 auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");

	
	
	}

}
