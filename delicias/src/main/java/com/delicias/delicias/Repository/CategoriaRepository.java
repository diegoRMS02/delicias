package com.delicias.delicias.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delicias.delicias.models.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{
    
}
