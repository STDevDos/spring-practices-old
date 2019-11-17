package com.froyo.service;

import com.froyo.domain.Categoria;

import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface CategoriaService {
    void save(Categoria categoria);

    Optional<Categoria> findOne(long rid);

    List<Categoria> findAll();
}
