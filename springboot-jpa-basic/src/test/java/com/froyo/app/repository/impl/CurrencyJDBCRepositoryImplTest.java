package com.froyo.app.repository.impl;

import com.froyo.app.model.entity.CurrencyEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class CurrencyJDBCRepositoryImplTest {

    @InjectMocks
    CurrencyJDBCRepositoryImpl repo;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Mock
    PreparedStatement preparedStatement;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
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

        int[][] result = {{1, 2}, {3, 4}};
        Mockito.when(
                jdbcTemplate.batchUpdate(
                        Mockito.anyString(), //
                        Mockito.anyCollection(), //
                        Mockito.anyInt(), //
                        Mockito.any(ParameterizedPreparedStatementSetter.class) //
                )).thenAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                Object obj[] = invocation.getArguments();
                ((ParameterizedPreparedStatementSetter) obj[3]).setValues(preparedStatement, ((ArrayList<CurrencyEntity>) obj[1]).get(0));

                return result;
            }
        });

        repo.batchInsert(currencyEntities);

    }
}
