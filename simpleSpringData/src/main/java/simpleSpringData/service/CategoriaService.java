package simpleSpringData.service;

import java.util.List;
import java.util.Optional;

import simpleSpringData.domain.Categoria;

/**
 * @author froy
 */
public interface CategoriaService {
    public void save(Categoria categoria);

    public Optional<Categoria> findOne(long rid);

    public List<Categoria> findAll();
}
