package com.froyo.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Mundo {

    @Value("Hola Mundo")
    private String saludo;

}
