package com.froyo.app.repository;

import com.froyo.app.model.entity.CurrencyEntity;

import java.util.List;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.core-concepts
public interface CurrencyJDBCRepository {
    int[][] batchInsert(List<CurrencyEntity> currencyEntities);
}
