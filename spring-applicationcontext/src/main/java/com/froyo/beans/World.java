package com.froyo.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class World {

    @Value("Hi world")
    private String greeting;

}
