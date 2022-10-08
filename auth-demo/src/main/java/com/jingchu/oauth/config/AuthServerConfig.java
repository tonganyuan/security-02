package com.jingchu.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

import java.util.Collections;

/**
 * @Author 郑彩
 * @Date 2022/10/7 19:46
 * @Version 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        InMemoryClientDetailsService clientDetailsService = new InMemoryClientDetailsService();
//
//        BaseClientDetails clientDetails = new BaseClientDetails();
//
//        clientDetails.setClientId("client");
//        clientDetails.setClientSecret("secret");
//        clientDetails.setScope(Collections.singleton("read"));
//        clientDetails.setAuthorizedGrantTypes(Collections.singleton("password"));
//        clientDetailsService.setClientDetailsStore(Collections.singletonMap("client", clientDetails));
//        clients.withClientDetails(clientDetailsService);

        clients.inMemory()
                .withClient("client")
                .secret("secret")
                .scopes("read")
                .authorizedGrantTypes("password","refresh_token");
    }
}
