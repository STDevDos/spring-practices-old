package com.froyo.practice.impl;

import com.froyo.practice.model.UserDetails;
import com.froyo.practice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    @CacheEvict(cacheNames = {"ten-second-cache", "twenty-second-cache", "ten-minutes-cache"}, allEntries = true)
    public void evictCache() {
        logger.info("Evict all cache entries...");
    }

    @Override
    @Cacheable(value = "ten-minutes-cache", key = "'student-cache_'+#login")
    public Optional<UserDetails> retrieveUserDetails(String login) {

        try {
            Thread.sleep(5000); // 5 seg.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<UserDetails> listUserDetails = new ArrayList<>();

        UserDetails userDetails001 = new UserDetails();
        userDetails001.setEmail("matt.murdock@company.com");
        userDetails001.setFirstName("Matt");
        userDetails001.setLastName("Murdock");
        userDetails001.setLogin("mmurdock");
        userDetails001.setUserId(001);
        userDetails001.setUserType("INTERNAL");

        UserDetails userDetails002 = new UserDetails();
        userDetails002.setEmail("jeff.render@company.com");
        userDetails002.setFirstName("Jeff");
        userDetails002.setLastName("Render");
        userDetails002.setLogin("jrender");
        userDetails002.setUserId(002);
        userDetails002.setUserType("EXTERNAL");

        UserDetails userDetails003 = new UserDetails();
        userDetails003.setEmail("roger.murdock@company.com");
        userDetails003.setFirstName("Roger");
        userDetails003.setLastName("Murdock");
        userDetails003.setLogin("rmurdock");
        userDetails003.setUserId(003);
        userDetails003.setUserType("INTERNAL");

        UserDetails userDetails004 = new UserDetails();
        userDetails004.setEmail("jorge.alfaro@company.com");
        userDetails004.setFirstName("Jorge");
        userDetails004.setLastName("Alfaro");
        userDetails004.setLogin("jalfaro");
        userDetails004.setUserId(004);
        userDetails004.setUserType(null);

        listUserDetails.add(userDetails001);
        listUserDetails.add(userDetails002);
        listUserDetails.add(userDetails003);
        listUserDetails.add(userDetails004);

        return listUserDetails.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

}
