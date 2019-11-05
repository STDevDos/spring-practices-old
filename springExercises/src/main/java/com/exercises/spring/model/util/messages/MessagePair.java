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

	private static final long serialVersionUID = 2734364864701881278L;
	
	private String code;
    private String description;
    private MessagePairTypeCode messagePairTypeCode;

}
