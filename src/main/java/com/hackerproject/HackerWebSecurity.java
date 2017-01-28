package com.hackerproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.hackerproject.repo.UsersRepo;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HackerWebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UsersRepo userrepo;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(new HackerUserDetail(userrepo));
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
		authorizeRequests()
		.antMatchers("/HACKER/ChallangesDemo/").hasAuthority("admin")
		.anyRequest().permitAll()
		.anyRequest().fullyAuthenticated().
		and().
		httpBasic()
		.
		realmName("Hacker")
		.and().csrf().disable()
		;
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
	return super.authenticationManager();
	}

	
}
