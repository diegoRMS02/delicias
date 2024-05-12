package com.delicias.delicias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class RolesUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRolesUsuario;

    private Integer idUsuario;

    private Integer idRoles;
}