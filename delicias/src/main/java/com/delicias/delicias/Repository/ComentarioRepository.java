package com.delicias.delicias.Repository;

import org.springframework.data.repository.CrudRepository;

import com.delicias.delicias.models.Comentario;

public interface ComentarioRepository  extends CrudRepository<Comentario, Integer>{
    
}
