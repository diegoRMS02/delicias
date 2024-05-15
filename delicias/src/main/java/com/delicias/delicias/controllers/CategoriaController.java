package com.delicias.delicias.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        return "Categorias/categoria";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("nuevaCategoria", new Categoria());
        return "Categorias/agregarCategoria";
    }

    @PostMapping("/guardar")
    public String agregarCategoria(@ModelAttribute Categoria nuevaCategoria) {
        categoriaService.guardarCategoria(nuevaCategoria);
        return "redirect:/categoria/listarTodo";
    }

    @RequestMapping(value="/actualizar/{id}")
    public ModelAndView actualizarCategoria(@PathVariable("id") Integer id) {
		ModelAndView mav= new ModelAndView("/Categorias/editarCategoria");
		Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
		mav.addObject("categoria", categoria);
		return mav;
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Integer id) {
        categoriaService.eliminarCategoriaPorId(id);
        return "redirect:/categoria/listarTodo"; 
    }
    
}
