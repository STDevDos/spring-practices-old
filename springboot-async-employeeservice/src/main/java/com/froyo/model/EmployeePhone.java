package com.froyo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EmployeePhone implements Serializable {

    private static final long serialVersionUID = 3705958972000701963L;
    public List<String> phoneNumbers;

    @JsonProperty("extraDataTest")
    public String extraDataTestJson() {
        return "data";
    }

}
