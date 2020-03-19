package com.froyo.beans;

import com.froyo.beans.common.codevalues.PlanetTypeEnum;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

/**
 * links:
 * https://www.baeldung.com/spring-value-annotation
 */
@Data
@Builder(toBuilder = true)
public class Planet {

    private PlanetTypeEnum planetTypeEnum;

}
