package com.froyo.common.codevalues;

import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ToString
public enum PlanetTypeEnum {

    MERCURY("Mercury",new BigDecimal(2439.7).setScale(2, RoundingMode.HALF_UP),"km"){

    },
    VENUS("Venus",new BigDecimal(6051.8).setScale(2, RoundingMode.HALF_UP),"km"){

    },
    EARTH("Earth",new BigDecimal(6371).setScale(2, RoundingMode.HALF_UP),"km"){

    },
    MARS("Mars",new BigDecimal(3389.5).setScale(2, RoundingMode.HALF_UP),"km"){

    },
    JUPITER("Jupiter",new BigDecimal(69911).setScale(2, RoundingMode.HALF_UP),"km"){

    },
    SATURN("Saturn",new BigDecimal(58232).setScale(2, RoundingMode.HALF_UP),"km"){

    },
    URANUS("Uranus",new BigDecimal(25362).setScale(2, RoundingMode.HALF_UP),"km"){

    },
    NEPTUNE("Neptune",new BigDecimal(24622).setScale(2, RoundingMode.HALF_UP),"km"){

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
