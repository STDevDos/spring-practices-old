package simpleSpringData.service;

import java.util.List;
import java.util.Optional;

import simpleSpringData.domain.Vendedor;

/**
 * @author froy
 */
public interface VendedorService {
    public void save(Vendedor Vendedor);

    public Optional<Vendedor> findOne(long rid);

    public List<Vendedor> findAll();
}
