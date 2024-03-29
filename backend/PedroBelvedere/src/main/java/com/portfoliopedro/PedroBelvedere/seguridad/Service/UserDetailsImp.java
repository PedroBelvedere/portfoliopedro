/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliopedro.PedroBelvedere.seguridad.Service;

import com.portfoliopedro.PedroBelvedere.seguridad.Entity.User;
import com.portfoliopedro.PedroBelvedere.seguridad.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */

@Service
public class UserDetailsImp implements UserDetailsService {
    @Autowired
    UserServicio userServicio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        User user = userServicio.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(user);
    }
    
    
    @Bean
public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsImp userDetailService) 
  throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
      .userDetailsService(userDetailService)
      .passwordEncoder(bCryptPasswordEncoder)
      .and()
      .build();
}

}
