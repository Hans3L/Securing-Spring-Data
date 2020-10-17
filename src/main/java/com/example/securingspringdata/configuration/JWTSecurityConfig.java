package com.example.securingspringdata.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {

    //token de acceso para escritura
    //token de acceso para leer

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(authz -> authz
                .antMatchers(HttpMethod.POST, "/foos").hasAuthority("SCOPE_write")
                .antMatchers(HttpMethod.GET, "/foos/**").hasAuthority("SCOPE_read")
                .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt());
    }
}
