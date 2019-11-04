package com.exercises.spring.model.util.messages;


import com.exercises.spring.model.messagescodes.FilesMessageCode;

public interface MessagePairUtils {

    static MessagePair messagePair(FilesMessageCode filesMessageCode) {
        return new MessagePair(filesMessageCode.getCode(), filesMessageCode.getDescription(), filesMessageCode.getMessagePairTypeCode());
    }

}
