package simpleSpringData.service.impl;

import com.fd.simpleSpringData.domain.Factura;
import com.fd.simpleSpringData.repository.FacturaRepository;
import com.fd.simpleSpringData.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Factura findOne(long rid) {
        return facturaRepository.findOne(rid);
    }

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }


}
