package com.froyo.inout;

import com.froyo.messages.AbstractResponse;
import com.froyo.model.Persona;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonaResponse extends AbstractResponse {

    private List<Persona> personas;

}
