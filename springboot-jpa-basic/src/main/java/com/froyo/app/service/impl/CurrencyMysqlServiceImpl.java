package com.froyo.app.service.impl;

import com.froyo.app.model.dto.CurrencyRequest;
import com.froyo.app.model.dto.CurrencyResponse;
import com.froyo.app.model.entity.CurrencyEntity;
import com.froyo.app.repository.mysql.CurrencyMysqlRepository;
import com.froyo.app.service.CurrencyService;
import com.froyo.messages.MessagePairUtils;
import com.froyo.messages.codes.CurrencyMessageCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("currencyMysqlServiceImpl")
public class CurrencyMysqlServiceImpl implements CurrencyService {

    private final CurrencyMysqlRepository currencyMysqlRepository;

    @Override
    public CurrencyResponse saveCurrency(final CurrencyRequest currencyRequest) {

        CurrencyResponse currencyResponse = new CurrencyResponse();

        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrency(currencyRequest.getCurrency());

        currencyMysqlRepository.save(currencyEntity);
        currencyResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));

        return currencyResponse;
    }

}
