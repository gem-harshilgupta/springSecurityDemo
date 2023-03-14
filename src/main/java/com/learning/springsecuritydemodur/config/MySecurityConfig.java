package com.learning.springsecuritydemodur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity // So we don't @Configuration as @EnableWebSecrity comes up with by default
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

 // NORMAL HTTP BASED AUTHENTICATION
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }

//    ROLE BASED AUTHENTICATION
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").hasRole("NORMAL")
                .antMatchers("/users/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

//IN MEMORY AUTHENTICATION WITH NoOpPasswordEncoder
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Harshil").password("helloharshil").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("Priyanshu").password("hellopriyanshu").roles("NORMAl");
//    }

    //IN MEMORY AUTHENTICATION WITH BCryptEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Harshil").password(this.passwordEncoder().encode("helloharshil")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Priyanshu").password(this.passwordEncoder().encode("hellopriyanshu")).roles("NORMAl");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
