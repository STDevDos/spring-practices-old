package com.froyo.inout;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaRequest implements Serializable {

    private Long id;
    private String name;
    private Integer age;

}
