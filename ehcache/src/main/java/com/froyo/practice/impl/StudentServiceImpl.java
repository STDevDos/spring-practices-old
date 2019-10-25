package com.froyo.practice.impl;

import com.froyo.practice.model.Student;
import com.froyo.practice.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student retrieveStudent(Long studentId) {
        if (1L == studentId) {
            return new Student(1, "Froyo", "Muguruza");
        } else {
            return new Student(2, "Dann", "Muguruza");
        }

    }

}
