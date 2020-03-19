package com.froyo.beans.common.codevalues;

import java.math.BigDecimal;

public enum PlanetTypeEnum {

    MERCURIO("Mercurio",new BigDecimal(2439.7),"km"){

    },
    VENUS("Venus",new BigDecimal(6051.8),"km"){

    },
    TIERRA("Tierra",new BigDecimal(6371),"km"){

    },
    MARTE("Marte",new BigDecimal(3389.5),"km"){

    };

    private final String name;
    private final BigDecimal radius;
    private final String unitOfMeasurement;

    PlanetTypeEnum(String name, BigDecimal radius,String unitOfMeasurement){
        this.name = name;
        this.radius = radius;
        this.unitOfMeasurement = unitOfMeasurement;
    }

}
