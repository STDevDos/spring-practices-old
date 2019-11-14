package com.froyo.practice.service;

import com.froyo.practice.model.UserDetails;

import java.util.Optional;

public interface UserService {

    void evictCache();

    Optional<UserDetails> retrieveUserDetails(String login);

}
