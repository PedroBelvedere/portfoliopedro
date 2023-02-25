/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliopedro.PedroBelvedere.seguridad.controller;

import com.portfoliopedro.PedroBelvedere.seguridad.Entity.Rol;
import com.portfoliopedro.PedroBelvedere.seguridad.Entity.User;
import com.portfoliopedro.PedroBelvedere.seguridad.Enums.RolNombre;
import com.portfoliopedro.PedroBelvedere.seguridad.Service.RolServicio;
import com.portfoliopedro.PedroBelvedere.seguridad.Service.UserServicio;
import com.portfoliopedro.PedroBelvedere.seguridad.jwt.JwtProvider;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserServicio userServicio;
    @Autowired
    RolServicio rolServicio;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensaje("Información mal introducida o inválida."), HttpStatus.BAD_REQUEST);
    
    if(userServicio.existByNombreUsuario(nombreUsuario.getNombreUsuario()))
        return new ResponseEntity(new Mensaje("Usuario ya existente."), HttpStatus.BAD_REQUEST);
    
    if(userServicio.existByEmail(nombreUsuario.getEmail()))
        return new ResponseEntity(new Mensaje("Email ya en uso."), HttpStatus.BAD_REQUEST);
    
    User user = new User(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
    
    Set<Rol> roles = new HashSet<>();
    roles.add(rolServicio.getByRolNombre(RolNombre.ROLE_USER).get());
    
    if(nuevoUsuario.getRoles().contains("admin"))
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
    
    user.setRoles(roles);
    userServicio.save(user);
    
    return new ResponseEntity(new Mensaje("Usuario creado exitosamente."), HttpStatus.CREATED);
    }
    
}
