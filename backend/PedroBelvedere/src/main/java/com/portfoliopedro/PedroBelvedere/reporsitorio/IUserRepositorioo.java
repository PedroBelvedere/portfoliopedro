
package com.portfoliopedro.PedroBelvedere.reporsitorio;

import com.portfoliopedro.PedroBelvedere.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro Belvedere
 */
@Repository
public interface IUserRepositorioo extends JpaRepository<Usuario,Long> {
    
}
