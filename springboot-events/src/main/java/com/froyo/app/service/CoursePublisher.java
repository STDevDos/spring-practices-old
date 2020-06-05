package com.froyo.app.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@Slf4j
@Component
@AllArgsConstructor
public class CoursePublisher {

    private final ApplicationEventPublisher publisher;

    @Async
    public void publish(String id) throws InterruptedException {
        log.info("PUBLISHER: Producing course");
        Thread.sleep(10_000); // 10 segundos
        Course course = new Course(id + " - " + randomNumeric(5));
        publisher.publishEvent(course);
    }


}
