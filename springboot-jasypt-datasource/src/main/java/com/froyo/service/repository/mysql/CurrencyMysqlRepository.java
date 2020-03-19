package com.froyo.service.repository.mysql;

import com.froyo.service.model.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyMysqlRepository extends JpaRepository<CurrencyEntity, Long> {
    //...
}
