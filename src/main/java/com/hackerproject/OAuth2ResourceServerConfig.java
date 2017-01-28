package com.hackerproject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.
EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.
ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.
ResourceServerSecurityConfigurer;
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter{
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
	resources.resourceId("HACKER_Resources");
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
	http
	.requestMatchers().antMatchers("/HACKER/Oauth/**")
	.and()
	.authorizeRequests().antMatchers("/HACKER/Oauth/**").authenticated()
	//.and().userDetailsService(userDetailsService)
	;
	}

}
