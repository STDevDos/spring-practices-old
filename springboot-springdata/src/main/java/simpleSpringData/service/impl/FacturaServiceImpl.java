package simpleSpringData.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simpleSpringData.domain.Factura;
import simpleSpringData.repository.FacturaRepository;
import simpleSpringData.service.FacturaService;

import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
@Transactional
@Service("facturaServiceImpl")
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public void save(Factura factura) {
        facturaRepository.save(factura);
    }

    @Override
    public Optional<Factura> findOne(long rid) {
        return facturaRepository.findById(rid);
    }

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }


}
