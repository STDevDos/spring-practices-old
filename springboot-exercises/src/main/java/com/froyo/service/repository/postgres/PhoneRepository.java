package com.froyo.service.repository.postgres;

import com.froyo.service.model.entity.postgres.PhoneEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {
    //...
}
