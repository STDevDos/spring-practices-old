package simpleSpringData.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import simpleSpringData.domain.Categoria;
import simpleSpringData.domain.Producto;

/**
 * @author froy
 * CrudRepository<[La clase que voy a usar],[el tipo de Id (primaryKey)
 */
public interface ProductoRepository extends CrudRepository<Producto, Long> {
    //NO NECESITA IMPLEMENTAR LOS MËTODOS CRUD (findAll,delete,etc...)

    /**
     * SELECT * FROM tblproducto WHERE nombre LIKE [parametroEnviado]
     *
     * @param nombreProducto
     * @return
     */
    public List<Producto> findByNombreProductoLike(String nombreProducto);

    /**
     * SELECT * FROM tblproducto WHERE update_date --
     *
     * @param updateDate
     * @return
     */
    public List<Producto> findByDateUpdateLessThan(Timestamp updateDate);

    /**
     * DELETE
     *
     * @param rid
     * @return
     */
    public long deleteByRid(long rid);

    /**
     * Obtener una lista de productos de una categoría.
     *
     * @param categoria
     * @return
     */
    public List<Producto> findByCategoria(Optional<Categoria> categoria);

    /**
     * Usando querydsl
     *
     * @param nombrecategoria
     * @return
     */
    public List<Producto> findByCategoria(String nombrecategoria);

    /**
     * Obtener todos los productos de finBy"Entidad"_"Atributo"() = Cantegoria_Categoria
     *
     * @param nombrecategoria
     * @return
     */
    public List<Producto> findByCategoria_Categoria(String nombrecategoria);

    /**
     * Buscando por Entidad Categoria.categoria & Entidad Producto.dateUpdate_LessThan
     * Al parecer como la entidad Categoria ya esta relacionada con producto ya no es necesario poner como nombre
     * del método algo como Categoria_CategoriaAndProducto_DateUpdate_LessThan
     *
     * @param nombrecategoria
     * @return Referencia: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
     */
    public List<Producto> findByCategoria_CategoriaAndDateUpdate_LessThan(String nombrecategoria, Timestamp dateUpdate);

    /**
     * Páginación.
     *
     * @param pageable
     * @return
     */
    public Page<Producto> findAll(Pageable pageable);

    /**
     * @param nombreCategoria
     * @param pageable
     * @return
     */
    public Page<Producto> findByCategoria_Categoria(String nombreCategoria, Pageable pageable);

}
