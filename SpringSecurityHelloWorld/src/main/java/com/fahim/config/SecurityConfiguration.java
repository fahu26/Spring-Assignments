package com.fahim.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("root").password("root123").roles("USER");
		auth.inMemoryAuthentication().withUser("bill").password("bill123").roles("ADMIN","USER");
	   }

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
	        .antMatchers("/", "/home").permitAll() 
	        .antMatchers("/admin/**").access("hasRole('ADMIN')")
	        .antMatchers("/user/**").access("hasRole('ADMIN') and hasRole('USER')")
	        .and().formLogin()
	        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
	  
	    }
}
