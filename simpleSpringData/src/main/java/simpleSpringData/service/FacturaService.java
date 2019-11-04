package simpleSpringData.service;

import java.util.List;
import java.util.Optional;

import simpleSpringData.domain.Factura;

/**
 * @author froy
 */
public interface FacturaService {
    public void save(Factura Vendedor);

    public Optional<Factura> findOne(long rid);

    public List<Factura> findAll();
}
