package com.froyo.practice.model;

import lombok.Data;

@Data
public class UserDetails {

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String forgerockCookie;
    private String oauthToken;
    private String userType;
    private Integer userId;

}
