package co.edu.icesi.ci.thymeval.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import co.edu.icesi.ci.thymeval.service.UserService;

@Configuration
public class SecurityConfiguration // extends WebSecurityConfigurerAdapter
	{

	@Autowired
	private UserService userDetailsService;
//	 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//	  throws Exception {
//	    auth.authenticationProvider(authenticationProvider());
//	}
//	 
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//	    DaoAuthenticationProvider authProvider
//	      = new DaoAuthenticationProvider();
//	    authProvider.setUserDetailsService(userDetailsService);
//	    authProvider.setPasswordEncoder(encoder());
//	    return authProvider;
//	}
//	 
//	@Bean
//	public PasswordEncoder encoder() {
//	    return new BCryptPasswordEncoder(11);
//	}

}