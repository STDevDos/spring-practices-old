package com.froyo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class Persona implements Serializable {

    private Long id;
    private String name;
    private Integer age;

}
