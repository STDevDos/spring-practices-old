package com.froyo.app.service;


import com.froyo.app.model.dto.CurrencyRequest;
import com.froyo.app.model.dto.CurrencyResponse;

public interface CurrencyService {
    CurrencyResponse saveCurrency(final CurrencyRequest currencyEntityDTO);
}
