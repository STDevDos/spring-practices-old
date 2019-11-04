package simpleSpringData.repository;

import org.springframework.data.repository.CrudRepository;

import simpleSpringData.domain.Vendedor;

/**
 * @author froy
 * CrudRepository<[La clase que voy a usar],[el tipo de Id (primaryKey)
 */
public interface VendedorRepository extends CrudRepository<Vendedor, Long> {
    //NO NECESITA IMPLEMENTAR LOS MËTODOS CRUD (findAll,delete,etc...)
}
