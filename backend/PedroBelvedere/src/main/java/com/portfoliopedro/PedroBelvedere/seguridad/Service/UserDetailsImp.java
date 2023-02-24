/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliopedro.PedroBelvedere.seguridad.Service;

import com.portfoliopedro.PedroBelvedere.seguridad.Entity.User;
import com.portfoliopedro.PedroBelvedere.seguridad.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    
}
