package com.froyo.repository.impl;

import com.froyo.model.entity.BasuraEntity;
import com.froyo.repository.BasuraRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BasuraRepositoryImpl implements BasuraRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<BasuraEntity> find(Integer basuraId) {

        try{
            String sql = "SELECT * FROM basura where basuraId = ?";
            Object[] object = new Object[] {
                    basuraId
            };

            BasuraEntity basuraEntity = (BasuraEntity) jdbcTemplate.queryForObject(sql,
                    object, new BeanPropertyRowMapper(BasuraEntity.class));

            return Optional.of(basuraEntity);

        }catch(DataAccessException dae){
            return Optional.empty();
        }

    }
}
