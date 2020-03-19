package com.froyo.service.repository;

import com.froyo.service.model.dto.CurrencyRequest;
import com.froyo.service.model.dto.CurrencyResponse;

public interface CurrencyH2Repository {
    CurrencyResponse saveCurrency(CurrencyRequest currencyEntityDTO);
}
