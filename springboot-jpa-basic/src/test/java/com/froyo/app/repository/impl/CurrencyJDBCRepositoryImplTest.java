package com.froyo.app.repository.impl;

import com.froyo.app.model.entity.CurrencyEntity;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class CurrencyJDBCRepositoryImplTest {

    private CurrencyJDBCRepositoryImpl currencyJDBCRepositoryImpl;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Before
    void setUp() throws IllegalAccessException {
        MockitoAnnotations.initMocks(true);
        currencyJDBCRepositoryImpl = new CurrencyJDBCRepositoryImpl();
        FieldUtils.writeField(currencyJDBCRepositoryImpl, //
                "jdbcTemplate", //
                jdbcTemplate
        );
    }

    @Test
    void batchInsert() {


        CurrencyEntity currencyEntity2 = new CurrencyEntity();
        currencyEntity2.setCurrency(LocalDateTime.now().toString());

        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrency("dolarucos");

        List<CurrencyEntity> currencyEntities = new ArrayList<>();
        currencyEntities.add(currencyEntity2);
        currencyEntities.add(currencyEntity);

        int[][] result = {{1,2},{3,4}};
        Mockito.when(
                jdbcTemplate.batchUpdate(
                        Mockito.isA(String.class), //
                        Mockito.isA(ArrayList.class), //
                        Mockito.isA(Integer.class), //
                        Mockito.isA(ParameterizedPreparedStatementSetter.class) //
                )).thenReturn(result);

        currencyJDBCRepositoryImpl.batchInsert(currencyEntities);

    }
}
