package simpleSpringData.repository;

import com.fd.simpleSpringData.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 * @author froy
 * CrudRepository<[La clase que voy a usar],[el tipo de Id (primaryKey)
 */
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    //NO NECESITA IMPLEMENTAR LOS MËTODOS CRUD (findAll,delete,etc...)
}
