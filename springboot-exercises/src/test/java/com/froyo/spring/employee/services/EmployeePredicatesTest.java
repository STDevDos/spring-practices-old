package com.froyo.spring.employee.services;

import com.froyo.spring.employee.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeePredicatesTest {

    private Employee employee;

    @BeforeAll
    static void beforeClass() {
        new EmployeePredicates();
    }

    @BeforeEach
    void setUp() {
        employee = null;
    }

    @Test
    void isAdultMale() {

        boolean result = EmployeePredicates.isAdultMale().test(employee);
        assertFalse(result);

        employee = new Employee();
        result = EmployeePredicates.isAdultMale().test(employee);
        assertFalse(result);

        employee = new Employee(1, 15, "M", "Froy", "Aguilar");
        result = EmployeePredicates.isAdultMale().test(employee);
        assertFalse(result);

        employee = new Employee(1, 25, "F", "Froy", "Aguilar");
        result = EmployeePredicates.isAdultMale().test(employee);
        assertFalse(result);

        employee = new Employee(1, 25, "M", "Froy", "Aguilar");
        result = EmployeePredicates.isAdultMale().test(employee);
        assertTrue(result);

    }

    @Test
    void isAdultFemale() {

        boolean result = EmployeePredicates.isAdultFemale().test(employee);
        assertFalse(result);

        employee = new Employee();
        result = EmployeePredicates.isAdultFemale().test(employee);
        assertFalse(result);

        employee = new Employee(1, 15, "F", "Froy", "Aguilar");
        result = EmployeePredicates.isAdultFemale().test(employee);
        assertFalse(result);

        employee = new Employee(1, 15, "M", "Froy", "Aguilar");
        result = EmployeePredicates.isAdultFemale().test(employee);
        assertFalse(result);

        employee = new Employee(1, 25, "F", "Froy", "Aguilar");
        result = EmployeePredicates.isAdultFemale().test(employee);
        assertTrue(result);

    }

    @Test
    void isAgeMoreThan() {

        boolean result = EmployeePredicates.isAgeMoreThan(0).test(employee);
        assertFalse(result);

        employee = new Employee();
        result = EmployeePredicates.isAgeMoreThan(0).test(employee);
        assertFalse(result);

        employee = new Employee(1, 25, "M", "Froy", "Aguilar");
        result = EmployeePredicates.isAgeMoreThan(25).test(employee);
        assertFalse(result);

        employee = new Employee(1, 25, "F", "Froy", "Aguilar");
        result = EmployeePredicates.isAgeMoreThan(24).test(employee);
        assertTrue(result);

    }
}
