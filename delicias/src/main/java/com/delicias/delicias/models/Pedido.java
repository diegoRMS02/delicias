package com.delicias.delicias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    
    private Integer idUsuario;
    
    private String fechaPedido;
    
    private String estadoProducto;
    
    private Integer cantidad;
    
    private Integer precioUnitario;
}