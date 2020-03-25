package com.froyo.app.repository.mysql;

import com.froyo.app.model.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyMysqlRepository extends JpaRepository<CurrencyEntity, Long> {
}
