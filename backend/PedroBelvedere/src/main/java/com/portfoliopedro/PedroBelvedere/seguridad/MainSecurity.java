/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliopedro.PedroBelvedere.seguridad;

import com.portfoliopedro.PedroBelvedere.seguridad.Service.UserDetailsImp;
import com.portfoliopedro.PedroBelvedere.seguridad.Service.UserServicio;
import com.portfoliopedro.PedroBelvedere.seguridad.jwt.JwtEntryPoint;
import com.portfoliopedro.PedroBelvedere.seguridad.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Pedro Belvedere, todos los derechos reservados 
 */


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity {
 @Autowired
 UserDetailsImp userDetailsServiceImp;
 @Autowired
 JwtEntryPoint jwtEntryPoint;
 
 @Bean
 public JwtTokenFilter jwtTokenFilter(){
 return new JwtTokenFilter();
 }


 @Bean
 public PasswordEncoder PasswordEncoder(){
 return new BCryptPasswordEncoder();
 }

 





}

