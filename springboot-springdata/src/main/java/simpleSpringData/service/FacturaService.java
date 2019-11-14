package simpleSpringData.service;

import simpleSpringData.domain.Factura;

import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface FacturaService {
    void save(Factura Vendedor);

    Optional<Factura> findOne(long rid);

    List<Factura> findAll();
}
