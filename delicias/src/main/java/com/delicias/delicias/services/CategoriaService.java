package com.delicias.delicias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delicias.delicias.Repository.CategoriaRepository;
import com.delicias.delicias.models.Categoria;

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

    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void eliminarCategoriaPorId(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
