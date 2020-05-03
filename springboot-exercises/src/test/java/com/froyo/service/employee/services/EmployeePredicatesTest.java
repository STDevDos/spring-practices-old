package com.froyo.service.employee.services;

import com.froyo.service.employee.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EmployeePredicatesTest {

    private Employee employee;

    @BeforeAll
    static void beforeClass() {
        new EmployeePredicates();
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("abc", 3),
                arguments("lemon", 2)
        );
    }

    @BeforeEach
    void setUp() {
        employee = null;
    }

    @Test
    @DisplayName("Test : Adulto masculino mayor de edad.")
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

    @ParameterizedTest(name = "#{index} - Test with {0} and {1}")
    @MethodSource("argumentProvider")
    void test_method_multi(String str, int length) {
    }
}
