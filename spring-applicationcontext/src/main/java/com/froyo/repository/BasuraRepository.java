package com.froyo.repository;

import com.froyo.model.entity.BasuraEntity;

import java.util.Optional;

public interface BasuraRepository {

    public Optional<BasuraEntity> find(Integer basuraId);

}
