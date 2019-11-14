package simpleSpringData.repository;

import org.springframework.data.repository.CrudRepository;
import simpleSpringData.domain.Factura;

/**
 * @author froy
 * CrudRepository<[La clase que voy a usar],[el tipo de Id (primaryKey)
 */
public interface FacturaRepository extends CrudRepository<Factura, Long> {
    //NO NECESITA IMPLEMENTAR LOS MËTODOS CRUD (findAll,delete,etc...)
}
