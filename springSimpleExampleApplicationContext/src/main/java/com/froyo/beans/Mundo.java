package com.froyo.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Mundo {

    @Value("Hola Mundo")
    private String saludo;

}
