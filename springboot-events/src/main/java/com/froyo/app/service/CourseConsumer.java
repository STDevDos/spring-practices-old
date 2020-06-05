package com.froyo.app.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CourseConsumer {

    @EventListener
    public void createCourse(Course course) {
        log.info("CONSUMER: A course has been created with title: " + course.getTitle());
    }

}
