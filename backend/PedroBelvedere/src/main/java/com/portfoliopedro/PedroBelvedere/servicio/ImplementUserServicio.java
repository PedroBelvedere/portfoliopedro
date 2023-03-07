
package com.portfoliopedro.PedroBelvedere.servicio;

import com.portfoliopedro.PedroBelvedere.entidad.Usuario;
import com.portfoliopedro.PedroBelvedere.interfaz.IUserServicio;
import com.portfoliopedro.PedroBelvedere.reporsitorio.IUserRepositorioo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro Belvedere
 */
@Service
public class ImplementUserServicio implements IUserServicio {
    @Autowired IUserRepositorioo iuserRepositorio;
            
    @Override
    public List<Usuario> getUsuario() {
    List<Usuario> usuario = iuserRepositorio.findAll();
    return usuario;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        iuserRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        iuserRepositorio.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = iuserRepositorio.findById(id).orElse(null);
        return usuario;
    }
    
}
