package simpleSpringData.service.impl;

import com.fd.simpleSpringData.domain.Categoria;
import com.fd.simpleSpringData.repository.CategoriaRepository;
import com.fd.simpleSpringData.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Categoria findOne(long rid) {
        return categoriaRepository.findOne(rid);
    }

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }


}
