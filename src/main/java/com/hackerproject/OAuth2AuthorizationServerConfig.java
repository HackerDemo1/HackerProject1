package com.hackerproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.
AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.
EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import javax.inject.Inject;
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
	throws Exception {
	endpoints.authenticationManager(this.authenticationManager);
	//endpoints.tokenGranter(tokenGranter(endpoints));
	}
	
	
	
	/*private TokenGranter tokenGranter(final AuthorizationServerEndpointsConfigurer endpoints) {
		List<TokenGranter> granters = new ArrayList<TokenGranter>(Arrays.asList(endpoints.getTokenGranter()));
		granters.add(new CustomTokenGranter(endpoints.getTokenServices(), endpoints.getClientDetailsService(), endpoints.getOAuth2RequestFactory(), "custom"));
		return new CompositeTokenGranter(granters);
	}*/
	
	@Override 
	   public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception { 
	       oauthServer.checkTokenAccess("permitAll()"); 
	   }
	
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	clients
	.inMemory()
	.withClient("hackerdemo")
	.secret("top_secret")
	.authorizedGrantTypes("password")
	.scopes("read", "write")
	.authorities()
	.accessTokenValiditySeconds(150000).authorizedGrantTypes("admin")
	.resourceIds("HACKER_Resources");
	}

}
