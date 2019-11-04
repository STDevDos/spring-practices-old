package com.exercises.spring.model.util.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class MessagePair implements Serializable {

    private String code;
    private String description;
    private MessagePairTypeCode messagePairTypeCode;

}
