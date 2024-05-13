package com.delicias.delicias.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.delicias.models.Categoria;  
import com.delicias.delicias.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listarTodo")
    public String mostrarTodasCategorias(Model model) {
        List<Categoria> categorias = categoriaService.obtenerTodasCategorias();
        model.addAttribute("listaCategorias", categorias);
        return "Categorias/ListarTodo";
    }

    @GetMapping("/categorias/{id}")
    public String mostrarCategoriaPorId(@PathVariable("id") Integer id, Model model) {
        Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
        categoria.ifPresent(value -> model.addAttribute("categoria", value));
        return "categoria";
    }

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @PutMapping("/categorias/{id}")
    public String actualizarCategoria(@PathVariable("id") Integer id, @ModelAttribute Categoria categoria) {
        categoria.setIdCategoria(id);
        categoriaService.actualizarCategoria(categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("/categorias/{id}")
    public String eliminarCategoria(@PathVariable("id") Integer id) {
        categoriaService.eliminarCategoriaPorId(id);
        return "redirect:/categorias";
    }
}
