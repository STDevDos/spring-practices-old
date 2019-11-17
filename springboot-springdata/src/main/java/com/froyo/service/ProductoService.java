package com.froyo.service;

import com.froyo.domain.Categoria;
import com.froyo.domain.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface ProductoService {
    void save(Producto producto);

    void save(List<Producto> listProducto);

    Optional<Producto> findOne(long rid);

    List<Producto> findAll();

    boolean exists(long rid);

    List<Producto> findByNombreProductoLike(String nombreProducto);

    List<Producto> findByDateUpdateLessThan(Timestamp updateDate);

    long deleteByRid(long rid);

    List<Producto> findByCategoria(Optional<Categoria> categoria);

    List<Producto> findByCategoria(String nombrecategoria);

    List<Producto> findByCategoria_Categoria(String nombrecategoria);

    List<Producto> findByCategoria_CategoriaAndDateUpdate_LessThan(String nombrecategoria, Timestamp dateUpdate);

    Page<Producto> findAll(Pageable pageable);

    Page<Producto> findByCategoria_Categoria(String nombreCategoria, Pageable pageable);
}
