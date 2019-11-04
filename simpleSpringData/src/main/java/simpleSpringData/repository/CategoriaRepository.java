package simpleSpringData.repository;

import org.springframework.data.repository.CrudRepository;

import simpleSpringData.domain.Categoria;

/**
 * @author froy
 * CrudRepository<[La clase que voy a usar],[el tipo de Id (primaryKey)
 */
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    //NO NECESITA IMPLEMENTAR LOS MËTODOS CRUD (findAll,delete,etc...)
}
