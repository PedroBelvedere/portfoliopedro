
package com.portfoliopedro.PedroBelvedere.controlador;

import com.portfoliopedro.PedroBelvedere.entidad.Usuario;
import com.portfoliopedro.PedroBelvedere.interfaz.IUserServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro Belvedere
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserControlador {
    @Autowired IUserServicio iuserServicio;
    
    
    @GetMapping("/usuarios/traer")
    public List<Usuario> getUsuario(){
        return iuserServicio.getUsuario();
    }
    
    @PostMapping("/usuarios/create")
    public String createUsuario(@RequestBody Usuario usuario){
        iuserServicio.guardarUsuario(usuario);
        return "Usuario registrado exitosamente." ;
    }
    
    @DeleteMapping("/usuarios/eliminar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        iuserServicio.eliminarUsuario(id);
        return "Usuario eliminado exitosamente.";
    }
    
    @PutMapping("/usuarios/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg){
        Usuario usuario = iuserServicio.findUsuario(id);
        usuario.setNombre(nuevoNombre);
        usuario.setApellido(nuevoApellido);
        usuario.setImg(nuevoImg);
        
        iuserServicio.guardarUsuario(usuario);
        return usuario;
    }
}
