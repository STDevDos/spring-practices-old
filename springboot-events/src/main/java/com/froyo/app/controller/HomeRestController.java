package com.froyo.app.controller;

import com.froyo.app.service.CourseConsumer;
import com.froyo.app.service.CoursePublisher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeRestController {

    private final CourseConsumer courseConsumer;
    private final CoursePublisher coursePublisher;

    @GetMapping("/home")
    public void home() throws InterruptedException {
        coursePublisher.publish("A");
        coursePublisher.publish("B");
        coursePublisher.publish("C");
        Thread.sleep(11_000); //11 segundos
    }

}
