package com.froyo.service.service.impl;

import com.froyo.service.model.dto.CurrencyRequest;
import com.froyo.service.model.dto.CurrencyResponse;
import com.froyo.service.repository.CurrencyH2Repository;
import com.froyo.service.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("currencyH2ServiceImpl")
public class CurrencyH2ServiceImpl implements CurrencyService {

    private final CurrencyH2Repository currencyH2Repository;

    @Override
    public CurrencyResponse saveCurrency(final CurrencyRequest currencyEntityDTO) {
        return currencyH2Repository.saveCurrency(currencyEntityDTO);
    }


}
