package com.froyo.spring.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.froyo.spring.model.entity.postgres.CurrrencyPostgresEntity;

public interface CurrencyPostgresRepository extends JpaRepository<CurrrencyPostgresEntity, Long> {
    //...
}
