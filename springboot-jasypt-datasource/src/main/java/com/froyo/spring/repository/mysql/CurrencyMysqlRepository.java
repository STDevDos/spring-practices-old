package com.froyo.spring.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.froyo.spring.model.entity.CurrencyEntity;

public interface CurrencyMysqlRepository extends JpaRepository<CurrencyEntity, Long> {
    //...
}
