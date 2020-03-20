package com.froyo.service;

import com.froyo.model.entity.BasuraEntity;

import java.util.Optional;

public interface BasuraService {

    public Optional<BasuraEntity> find(Integer basuraId);

}
