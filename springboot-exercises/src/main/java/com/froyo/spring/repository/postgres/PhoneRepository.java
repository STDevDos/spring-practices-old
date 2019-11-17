package com.froyo.spring.repository.postgres;

import com.froyo.spring.model.entity.postgres.PhoneEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {
    //...
}
