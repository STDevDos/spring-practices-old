package com.froyo.model.dto;

import com.froyo.common.codevalues.PlanetTypeEnum;
import lombok.Builder;
import lombok.Data;

/**
 * links:
 * https://www.baeldung.com/spring-value-annotation
 */
@Data
@Builder(toBuilder = true)
public class PlanetDTO {

    private PlanetTypeEnum planetTypeEnum;

}
