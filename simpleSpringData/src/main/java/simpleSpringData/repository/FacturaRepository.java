package simpleSpringData.repository;

import com.fd.simpleSpringData.domain.Factura;
import org.springframework.data.repository.CrudRepository;

/**
 * @author froy
 * CrudRepository<[La clase que voy a usar],[el tipo de Id (primaryKey)
 */
public interface FacturaRepository extends CrudRepository<Factura, Long> {
    //NO NECESITA IMPLEMENTAR LOS MËTODOS CRUD (findAll,delete,etc...)
}
