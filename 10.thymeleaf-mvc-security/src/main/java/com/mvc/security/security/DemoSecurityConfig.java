package com.mvc.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}shelby")
                .roles("EMPLOYEE")
                .build();

        UserDetails arthur = User.builder()
                .username("arthur")
                .password("{noop}shelby")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails thomas = User.builder()
                .username("thomas")
                .password("{noop}shelby")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(john,arthur,thomas);
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );
        return http.build();
    }





}










