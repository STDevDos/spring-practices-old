package com.froyo.spring.model.util.messages;


import com.froyo.spring.model.messagescodes.FilesMessageCode;

public interface MessagePairUtils {

    static MessagePair messagePair(FilesMessageCode filesMessageCode) {
        return new MessagePair(filesMessageCode.getCode(), filesMessageCode.getDescription(), filesMessageCode.getMessagePairTypeCode());
    }

}
