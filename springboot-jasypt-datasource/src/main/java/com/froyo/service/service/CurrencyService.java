package com.froyo.service.service;

import com.froyo.service.model.dto.CurrencyRequest;
import com.froyo.service.model.dto.CurrencyResponse;

public interface CurrencyService {

    CurrencyResponse saveCurrency(final CurrencyRequest currencyEntityDTO);

}
