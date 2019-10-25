package simpleSpringData.service;

import com.fd.simpleSpringData.domain.Categoria;

import java.util.List;

/**
 * @author froy
 */
public interface CategoriaService {
    public void save(Categoria categoria);

    public Categoria findOne(long rid);

    public List<Categoria> findAll();
}
