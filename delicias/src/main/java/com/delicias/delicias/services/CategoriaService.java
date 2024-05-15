package com.delicias.delicias.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delicias.delicias.Repository.CategoriaRepository;
import com.delicias.delicias.models.Categoria;
import com.delicias.delicias.models.Producto;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodasCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    public Optional<Categoria> obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Categoria categoriaActualizar) {
        Categoria categoriaActual = categoriaRepository.findById(categoriaActualizar.getIdCategoria()).get();
        categoriaActual.setTipoCategoria(categoriaActualizar.getTipoCategoria());
        return categoriaRepository.save(categoriaActual);
    }

    public void eliminarCategoriaPorId(Integer id) {
        categoriaRepository.deleteById(id);
    }

    public List<Producto> obtenerProductosDeCategoria(Integer idCategoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(idCategoria);
        if (optionalCategoria.isPresent()) {
            Categoria categoria = optionalCategoria.get();
            return new ArrayList<>(categoria.getProductos());
        } else {
            // La categoría no existe
            return new ArrayList<>();
        }
    }
}
