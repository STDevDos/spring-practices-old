package com.froyo.inout;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PersonaRequest implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private Integer age;

}
