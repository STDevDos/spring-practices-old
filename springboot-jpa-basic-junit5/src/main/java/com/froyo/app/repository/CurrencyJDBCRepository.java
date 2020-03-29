package com.froyo.app.repository;

import com.froyo.app.model.entity.CurrencyEntity;

import java.util.List;

public interface CurrencyJDBCRepository {
    int[][] batchInsert(List<CurrencyEntity> currencyEntities);
}
