package simpleSpringData.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import simpleSpringData.domain.Categoria;
import simpleSpringData.repository.CategoriaRepository;
import simpleSpringData.service.CategoriaService;

/**
 * @author froy
 */
@Transactional
@Service("categoriaServiceImpl")
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> findOne(long rid) {
        return categoriaRepository.findById(rid);
    }

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }


}
