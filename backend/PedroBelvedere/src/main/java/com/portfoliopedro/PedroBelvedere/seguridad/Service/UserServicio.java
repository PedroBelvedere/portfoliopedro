/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliopedro.PedroBelvedere.seguridad.Service;

import com.portfoliopedro.PedroBelvedere.seguridad.Entity.User;
import com.portfoliopedro.PedroBelvedere.seguridad.Repository.IUserRepositorio;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
@Transactional
public class UserServicio {
    @Autowired
    IUserRepositorio iuserRepositorio;
    
    public Optional<User> getByNombreUsuario(String nombreUsuario){
    return iuserRepositorio.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByNombreUsuario(String nombreUsuario){
    return iuserRepositorio.existByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByEmail(String email){
    return iuserRepositorio.existByEmail(email);
    }
    public void save(User user){
    iuserRepositorio.save(user);
    }
}
