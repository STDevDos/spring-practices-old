package com.froyo.app.service;


import com.froyo.app.model.dto.CurrencyEntityDTORequest;
import com.froyo.app.model.dto.CurrencyEntityDTOResponse;
import com.froyo.app.model.entity.CurrencyEntity;

import java.util.Optional;

public interface CurrencyService {
    CurrencyEntityDTOResponse saveCurrency(final CurrencyEntityDTORequest dtoRequest);
    Optional<CurrencyEntity> retrieveCurrency();
}
