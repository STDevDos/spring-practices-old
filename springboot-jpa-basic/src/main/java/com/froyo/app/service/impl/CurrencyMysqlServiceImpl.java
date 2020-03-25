package com.froyo.app.service.impl;

import com.froyo.app.model.dto.CurrencyEntityDTORequest;
import com.froyo.app.model.dto.CurrencyEntityDTOResponse;
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
    public CurrencyEntityDTOResponse saveCurrency(final CurrencyEntityDTORequest dtoRequest) {

        CurrencyEntityDTOResponse dtoResponse = new CurrencyEntityDTOResponse();

        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrency(dtoRequest.getCurrency());

        currencyMysqlRepository.save(currencyEntity);
        dtoResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));

        return dtoResponse;
    }

}
