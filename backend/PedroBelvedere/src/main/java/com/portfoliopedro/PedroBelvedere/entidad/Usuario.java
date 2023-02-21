
package com.portfoliopedro.PedroBelvedere.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Pedro Belvedere
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 2, max = 30, message = "Por favor, ingrese un ID de entre 2 a 50 caracteres.")
    private String nombre;
    @NotNull
    @Size(min = 2, max = 30, message = "Por favor, ingrese un ID de entre 2 a 50 caracteres.")
    private String apellido;
    
    @Size(min = 2, max = 30, message = "Por favor, ingrese un ID de entre 2 a 50 caracteres.")
    private String img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
