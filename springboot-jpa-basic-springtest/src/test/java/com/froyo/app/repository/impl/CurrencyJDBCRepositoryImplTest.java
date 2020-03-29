//package com.froyo.app.repository.impl;
//
//import com.froyo.app.SpringBootJPABasicTest;
//import com.froyo.app.config.MysqlHikariConfig;
//import com.froyo.app.config.MysqlJPAConfig;
//import com.froyo.app.model.entity.CurrencyEntity;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.stubbing.Answer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.sql.PreparedStatement;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//public class CurrencyJDBCRepositoryImplTest {
//
//    @Autowired
//    private CurrencyJDBCRepositoryImpl repo;
//
//    @MockBean
//    private JdbcTemplate jdbcTemplate;
//
//    @Mock
//    private PreparedStatement preparedStatement;
//
//    @Test
//    public void batchInsert() {
//
//        CurrencyEntity currencyEntity2 = new CurrencyEntity();
//        currencyEntity2.setCurrency(LocalDateTime.now().toString());
//
//        CurrencyEntity currencyEntity = new CurrencyEntity();
//        currencyEntity.setCurrency("dolarucos");
//
//        List<CurrencyEntity> currencyEntities = new ArrayList<>();
//        currencyEntities.add(currencyEntity2);
//        currencyEntities.add(currencyEntity);
//
//        int[][] result = {{1, 2}, {3, 4}};
//        when(jdbcTemplate.batchUpdate(
//                "insert into currency (currency) values(?)",
//                currencyEntities,
//                currencyEntities.size(),
//                (ps, argument) -> ps.setString(1, argument.getCurrency())
//        )).thenAnswer(new Answer() {
//
//            @Override
//            public Object answer(InvocationOnMock invocation) throws Throwable {
//
//                Object obj[] = invocation.getArguments();
//                ((ParameterizedPreparedStatementSetter) obj[3]).setValues(preparedStatement, ((ArrayList<CurrencyEntity>) obj[1]).get(0));
//
//                return result;
//            }
//        });
//
//        repo.batchInsert(currencyEntities);
//
//    }
//}
