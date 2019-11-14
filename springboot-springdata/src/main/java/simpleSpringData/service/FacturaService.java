package simpleSpringData.service;

import simpleSpringData.domain.Factura;

import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface FacturaService {
    public void save(Factura Vendedor);

    public Optional<Factura> findOne(long rid);

    public List<Factura> findAll();
}
