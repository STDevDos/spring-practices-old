package com.froyo.service.repository.postgres;

import com.froyo.service.model.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyPostgresRepository extends JpaRepository<CurrencyEntity, Long> {
    //...
}
