package com.exercises.spring.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

}
