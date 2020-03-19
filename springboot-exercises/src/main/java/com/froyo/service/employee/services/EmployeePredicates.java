package com.froyo.service.employee.services;

import com.froyo.service.employee.model.Employee;

import java.util.Objects;
import java.util.function.Predicate;

class EmployeePredicates {

    static Predicate<Employee> isAdultMale() {
        return employee -> Objects.nonNull(employee) //
                && Objects.nonNull(employee.getAge()) //
                && employee.getAge() >= 18 //
                && "M".equals(employee.getGender());
    }

    static Predicate<Employee> isAdultFemale() {
        return employee -> Objects.nonNull(employee) //
                && Objects.nonNull(employee.getAge()) //
                && employee.getAge() >= 18 //
                && "F".equals(employee.getGender());
    }

    static Predicate<Employee> isAgeMoreThan(Integer age) {
        return employee -> Objects.nonNull(employee) //
                && Objects.nonNull(employee.getAge()) //
                && employee.getAge() > age;
    }
}
