package simpleSpringData.service;

import simpleSpringData.domain.Categoria;

import java.util.List;
import java.util.Optional;

/**
 * @author froy
 */
public interface CategoriaService {
    public void save(Categoria categoria);

    public Optional<Categoria> findOne(long rid);

    public List<Categoria> findAll();
}
