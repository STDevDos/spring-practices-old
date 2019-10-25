package simpleSpringData.service;

import com.fd.simpleSpringData.domain.Categoria;
import com.fd.simpleSpringData.domain.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author froy
 */
public interface ProductoService {
    public void save(Producto producto);

    public void save(List<Producto> listProducto);

    public Producto findOne(long rid);

    public List<Producto> findAll();

    public boolean exists(long rid);

    public List<Producto> findByNombreProductoLike(String nombreProducto);

    public List<Producto> findByDateUpdateLessThan(Timestamp updateDate);

    public long deleteByRid(long rid);

    public List<Producto> findByCategoria(Categoria categoria);

    public List<Producto> findByCategoria(String nombrecategoria);

    public List<Producto> findByCategoria_Categoria(String nombrecategoria);

    public List<Producto> findByCategoria_CategoriaAndDateUpdate_LessThan(String nombrecategoria, Timestamp dateUpdate);

    public Page<Producto> findAll(Pageable pageable);

    public Page<Producto> findByCategoria_Categoria(String nombreCategoria, Pageable pageable);
}
