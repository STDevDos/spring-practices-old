package com.froyo.spring.util.messages;

import com.froyo.spring.util.messages.codes.CurrencyMessageCode;

public interface MessagePairUtils {

    static MessagePair messagePair(CurrencyMessageCode currencyMessageCode) {
        return new MessagePair(currencyMessageCode.getCode(), //
                currencyMessageCode.getDescription(), //
                currencyMessageCode.getMessagePairTypeCode());
    }

}
