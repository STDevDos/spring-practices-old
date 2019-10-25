package com.froyo.practice.practice.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
