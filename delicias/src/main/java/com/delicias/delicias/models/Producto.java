package com.delicias.delicias.models;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProducto;

    @Column(name="nombre_producto")
    private String nombreProducto;

    @Column(name="descripcion_producto")
    private String descripcionProducto;

    @Column(name="precio_producto")
    private Integer precioProducto;

    @Column(name="imagen_producto")
    private String imagenProducto;

    @Column(name="descuento_producto")
    private Integer descuentoProducto;
    @Column(name="id_usuario_producto")
    private Integer idUsuarioProducto;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "producto_categoria",
               joinColumns = @JoinColumn(name = "id_producto"),
               inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> categorias = new HashSet<>();

    // Constructor, getters y setters
}
