package simpleSpringData.service;

import com.fd.simpleSpringData.domain.Factura;

import java.util.List;

/**
 * @author froy
 */
public interface FacturaService {
    public void save(Factura Vendedor);

    public Factura findOne(long rid);

    public List<Factura> findAll();
}
