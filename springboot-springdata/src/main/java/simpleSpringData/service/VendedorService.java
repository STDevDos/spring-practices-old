package simpleSpringData.service;

import simpleSpringData.domain.Vendedor;

import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface VendedorService {
    void save(Vendedor Vendedor);

    Optional<Vendedor> findOne(long rid);

    List<Vendedor> findAll();
}
