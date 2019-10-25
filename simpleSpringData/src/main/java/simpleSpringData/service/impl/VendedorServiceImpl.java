package simpleSpringData.service.impl;

import com.fd.simpleSpringData.domain.Vendedor;
import com.fd.simpleSpringData.repository.VendedorRepository;
import com.fd.simpleSpringData.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author froy
 */
@Transactional
@Service("vendedorServiceImpl")
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public void save(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor findOne(long rid) {
        return vendedorRepository.findOne(rid);
    }

    @Override
    public List<Vendedor> findAll() {
        return (List<Vendedor>) vendedorRepository.findAll();
    }


}
