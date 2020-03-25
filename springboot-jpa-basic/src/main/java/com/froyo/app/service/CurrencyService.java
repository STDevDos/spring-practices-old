package com.froyo.app.service;


import com.froyo.app.model.dto.CurrencyEntityDTORequest;
import com.froyo.app.model.dto.CurrencyEntityDTOResponse;

public interface CurrencyService {
    CurrencyEntityDTOResponse saveCurrency(final CurrencyEntityDTORequest dtoRequest);
}
