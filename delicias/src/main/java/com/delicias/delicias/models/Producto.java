package com.delicias.delicias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombreProducto;

    private String descripcionProducto;

    private Integer precioProducto;

    private String imagenProducto;

    private Integer descuentoProducto;

    private Integer idUsuariosProductos;

}