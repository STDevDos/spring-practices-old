package com.froyo.service.impl;

import com.froyo.model.entity.BasuraEntity;
import com.froyo.repository.BasuraRepository;
import com.froyo.service.BasuraService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasuraServiceImpl implements BasuraService {

    @Autowired
    private BasuraRepository basuraRepository;

    @Override
    public Optional<BasuraEntity> find(Integer basuraId) {
        return basuraRepository.find(basuraId);
    }

}
