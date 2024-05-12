package com.delicias.delicias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nombreUsuario;

    private String apellidoUsuario;

    private String celularUsuario;

    private String correoUsuario;

    private String contraseñaUsuario;

    private String fechaRegistroUsuario;

}