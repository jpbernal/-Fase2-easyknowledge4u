package es.codeurjc.easyknowledge4u.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import es.codeurjc.easyknowledge4u.Repositories.UserRepositoryAuthenticationProvider;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    public UserRepositoryAuthenticationProvider userRepoAuthProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/contacto").permitAll();
        http.authorizeRequests().antMatchers("/guardarContacto").permitAll();
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
 

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/newcurso").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/editcurso/*").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/removecurso/*").hasAnyRole("ADMIN");

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
               
        http.headers().frameOptions().disable();
        }
  
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Database authentication provider
        auth.authenticationProvider(userRepoAuthProvider);
    }

	
	
}
