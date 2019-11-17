package com.froyo.service.impl;

import com.froyo.domain.Vendedor;
import com.froyo.repository.VendedorRepository;
import com.froyo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
