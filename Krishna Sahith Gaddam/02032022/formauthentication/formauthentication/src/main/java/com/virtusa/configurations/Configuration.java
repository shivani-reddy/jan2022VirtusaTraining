package com.virtusa.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.virtusa.login.Logindetails;


@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter{
	@Autowired
	private Logindetails loginService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService);
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().httpBasic().and().authorizeRequests().anyRequest().authenticated()
	        .and().authorizeRequests().antMatchers("/login/**").permitAll()
	        .and().formLogin();
	    }

}
