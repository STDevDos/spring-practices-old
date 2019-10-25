package simpleSpringData.service.impl;

import com.fd.simpleSpringData.domain.Categoria;
import com.fd.simpleSpringData.domain.Producto;
import com.fd.simpleSpringData.domain.dsl.QCategoria;
import com.fd.simpleSpringData.domain.dsl.QProducto;
import com.fd.simpleSpringData.repository.ProductoRepository;
import com.fd.simpleSpringData.service.ProductoService;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author froy
 */
@Transactional
@Service("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private EntityManager entityManager; //como el session.

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void save(List<Producto> listProducto) {
        productoRepository.save(listProducto);
    }

    @Override
    public Producto findOne(long rid) {
        return productoRepository.findOne(rid);
    }

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public boolean exists(long rid) {
        return productoRepository.exists(rid);
    }

    @Override
    public List<Producto> findByNombreProductoLike(String nombreProducto) {
        return (List<Producto>) productoRepository.findByNombreProductoLike("%" + nombreProducto + "%");
    }

    @Override
    public List<Producto> findByDateUpdateLessThan(Timestamp updateDate) {
        return (List<Producto>) productoRepository.findByDateUpdateLessThan(updateDate);
    }

    @Override
    public long deleteByRid(long rid) {
        return productoRepository.deleteByRid(rid);
    }

    @Override
    public List<Producto> findByCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Producto> findByCategoria(String nombrecategoria) {

        QCategoria qCategoria = QCategoria.categoria1;
        QProducto qProducto = QProducto.producto;

        return new JPAQuery(entityManager)
                .from(qCategoria)
                .join(qCategoria.productos, qProducto)
                .where(qCategoria.categoria.eq(nombrecategoria))
                .list(qProducto);
    }

    @Override
    public List<Producto> findByCategoria_Categoria(String nombrecategoria) {
        return productoRepository.findByCategoria_Categoria(nombrecategoria);
    }

    @Override
    public List<Producto> findByCategoria_CategoriaAndDateUpdate_LessThan(String nombrecategoria,
                                                                          Timestamp dateUpdate) {
        return productoRepository.findByCategoria_CategoriaAndDateUpdate_LessThan(nombrecategoria, dateUpdate);
    }

    @Override
    public Page<Producto> findAll(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public Page<Producto> findByCategoria_Categoria(String nombreCategoria, Pageable pageable) {
        return productoRepository.findByCategoria_Categoria(nombreCategoria, pageable);
    }

}
