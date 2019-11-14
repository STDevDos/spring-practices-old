package simpleSpringData.service;

import simpleSpringData.domain.Vendedor;

import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface VendedorService {
    public void save(Vendedor Vendedor);

    public Optional<Vendedor> findOne(long rid);

    public List<Vendedor> findAll();
}
