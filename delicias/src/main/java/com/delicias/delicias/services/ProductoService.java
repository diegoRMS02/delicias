package com.delicias.delicias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delicias.delicias.Repository.ProductoRepository;
import com.delicias.delicias.models.Producto;

@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Producto productoActualizar) {
        Producto productoActual = productoRepository.findById(productoActualizar.getIdProducto()).orElse(null);
        if (productoActual != null) {
            productoActual.setNombreProducto(productoActualizar.getNombreProducto());
            productoActual.setDescripcionProducto(productoActualizar.getDescripcionProducto());
            productoActual.setPrecioProducto(productoActualizar.getPrecioProducto());
            productoActual.setImagenProducto(productoActualizar.getImagenProducto());
            productoActual.setDescuentoProducto(productoActualizar.getDescuentoProducto());
            productoActual.setIdUsuarioProducto(productoActualizar.getIdUsuarioProducto());
            return productoRepository.save(productoActual);
        } else {
            return null;
        }
    }

    public void eliminarProductoPorId(Integer id) {
        productoRepository.deleteById(id);
    }
}
