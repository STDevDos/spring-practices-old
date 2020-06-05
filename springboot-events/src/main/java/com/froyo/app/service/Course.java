package com.froyo.app.service;

import lombok.Getter;

@Getter
public class Course {

    private String title;

    public Course(String title) {
        this.title = title;
    }

}
