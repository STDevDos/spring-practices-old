package simpleSpringData.service;

import com.fd.simpleSpringData.domain.Vendedor;

import java.util.List;

/**
 * @author froy
 */
public interface VendedorService {
    public void save(Vendedor Vendedor);

    public Vendedor findOne(long rid);

    public List<Vendedor> findAll();
}
