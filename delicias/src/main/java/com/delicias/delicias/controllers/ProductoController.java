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

import com.delicias.delicias.models.Producto;
import com.delicias.delicias.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.obtenerTodosProductos();
        model.addAttribute("productos", productos);
        return "Productos/listarTodo";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "Productos/agregarProducto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos/listar";
    }
    @GetMapping("/actualizar/{id}") // Añade esta anotación para manejar solicitudes GET
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "productos/editarProducto"; // Cambiado el nombre de la vista
        } else {
            return "redirect:/productos/listar";
        }
    }
    // @GetMapping("/editar/{id}")
    // public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
    //     Optional<Producto> producto = productoService.obtenerProductoPorId(id);
    //     if (producto.isPresent()) {
    //         model.addAttribute("producto", producto.get());
    //         return "productos/editarProducto";
    //     } else {
    //         return "redirect:/productos/listar";
    //     }
    // }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id) {
        productoService.eliminarProductoPorId(id);
        return "redirect:/productos/listar";
    }
}
