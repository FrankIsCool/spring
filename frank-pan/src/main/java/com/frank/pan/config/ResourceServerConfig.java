package com.frank.pan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/19
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${spring.config.jwt.signing-key}")
    private String signingKey;
    @Value("${spring.config.jwt.verifier-key}")
    private String verifierKey;

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(signingKey);
        accessTokenConverter.setVerifierKey(verifierKey);
        return accessTokenConverter;
    }

    @Autowired
    private TokenStore jwtTokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources){
        resources.tokenStore(jwtTokenStore);
    }

    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("user-frank-knDlT0NQHEfZVcoWjIV5rWawgVq8baao");
        System.out.println(encode);
    }
}
