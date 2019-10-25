package com.froyo.practice.controller;

import com.froyo.practice.model.Student;
import com.froyo.practice.model.UserDetails;
import com.froyo.practice.service.StudentService;
import com.froyo.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/student")
public class StudentRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    private static final String USERID = "X-USERID";

    @GetMapping(path = "/evictCache")
    public void evictCache() {
        userService.evictCache();
    }

    @PostMapping(value = "/studentId")
    @ResponseBody
    public Student studentId(@RequestParam(required = false) Long studentId,
                             @RequestHeader(USERID) String login) {

        Optional<UserDetails> optUserDetails = userService.retrieveUserDetails(login);

        if (optUserDetails.isPresent()) {

            UserDetails currentUserDetails = optUserDetails.get();

            if ("INTERNAL".equals(currentUserDetails.getUserType())) {
                return studentService.retrieveStudent(studentId);
            } else if ("EXTERNAL".equals(currentUserDetails.getUserType())) {
                return new Student(100L, "Pepe", "Filetes");
            } else {
                return null;
            }
        }

        return null;
    }

}
