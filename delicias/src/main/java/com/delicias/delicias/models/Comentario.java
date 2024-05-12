package com.delicias.delicias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    private Integer productoId;

    private Integer usuarioId;

    private String comentario;

    private Integer imagen;

   // ... (otros campos y métodos getter y setter)
}