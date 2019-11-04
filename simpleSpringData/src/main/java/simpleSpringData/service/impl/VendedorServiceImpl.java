package simpleSpringData.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import simpleSpringData.domain.Vendedor;
import simpleSpringData.repository.VendedorRepository;
import simpleSpringData.service.VendedorService;

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
    public Optional<Vendedor> findOne(long rid) {
        return vendedorRepository.findById(rid);
    }

    @Override
    public List<Vendedor> findAll() {
        return (List<Vendedor>) vendedorRepository.findAll();
    }


}
