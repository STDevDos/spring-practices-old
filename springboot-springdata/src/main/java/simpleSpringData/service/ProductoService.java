package simpleSpringData.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import simpleSpringData.domain.Categoria;
import simpleSpringData.domain.Producto;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface ProductoService {
    public void save(Producto producto);

    public void save(List<Producto> listProducto);

    public Optional<Producto> findOne(long rid);

    public List<Producto> findAll();

    public boolean exists(long rid);

    public List<Producto> findByNombreProductoLike(String nombreProducto);

    public List<Producto> findByDateUpdateLessThan(Timestamp updateDate);

    public long deleteByRid(long rid);

    public List<Producto> findByCategoria(Optional<Categoria> categoria);

    public List<Producto> findByCategoria(String nombrecategoria);

    public List<Producto> findByCategoria_Categoria(String nombrecategoria);

    public List<Producto> findByCategoria_CategoriaAndDateUpdate_LessThan(String nombrecategoria, Timestamp dateUpdate);

    public Page<Producto> findAll(Pageable pageable);

    public Page<Producto> findByCategoria_Categoria(String nombreCategoria, Pageable pageable);
}
