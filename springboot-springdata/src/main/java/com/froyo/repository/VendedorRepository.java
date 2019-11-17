package com.froyo.repository;

import com.froyo.domain.Vendedor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author froy
 * CrudRepository<[La clase que voy a usar],[el tipo de Id (primaryKey)
 */
public interface VendedorRepository extends CrudRepository<Vendedor, Long> {
    //NO NECESITA IMPLEMENTAR LOS MËTODOS CRUD (findAll,delete,etc...)
}
