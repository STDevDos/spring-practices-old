package com.froyo.model;

import com.froyo.customvalidation.constraints.AerolineaConstraint;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ViajeRequest {

    @NotNull
    @AerolineaConstraint
    private String aerolinea;

}
