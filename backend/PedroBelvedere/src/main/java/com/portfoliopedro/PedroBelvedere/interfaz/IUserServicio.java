
package com.portfoliopedro.PedroBelvedere.interfaz;

import com.portfoliopedro.PedroBelvedere.entidad.Usuario;
import java.util.List;


/**
 *
 * @author Pedro Belvedere
 */
public interface IUserServicio {
    public List<Usuario> getUsuario();
    public void guardarUsuario(Usuario usuario);
    public void eliminarUsuario(Long id);
    public Usuario findUsuario(Long id);
}
