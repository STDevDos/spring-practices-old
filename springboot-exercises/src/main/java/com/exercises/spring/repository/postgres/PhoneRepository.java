package com.exercises.spring.repository.postgres;

import com.exercises.spring.model.entity.postgres.PhoneEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {
    //...
}
