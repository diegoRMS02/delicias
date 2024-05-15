package com.delicias.delicias.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delicias.delicias.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
