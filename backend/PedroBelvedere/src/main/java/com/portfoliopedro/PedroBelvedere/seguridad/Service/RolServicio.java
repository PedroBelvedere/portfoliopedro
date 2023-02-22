/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliopedro.PedroBelvedere.seguridad.Service;

import com.portfoliopedro.PedroBelvedere.seguridad.Entity.Rol;
import com.portfoliopedro.PedroBelvedere.seguridad.Enums.RolNombre;
import com.portfoliopedro.PedroBelvedere.seguridad.Repository.IRolRepositorio;
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
public class RolServicio {
    @Autowired
    IRolRepositorio irolRepositorio;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
   return irolRepositorio.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepositorio.save(rol);
    }
}
