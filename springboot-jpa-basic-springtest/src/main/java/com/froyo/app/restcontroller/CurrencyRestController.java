package com.froyo.app.restcontroller;

import com.froyo.app.model.dto.CurrencyEntityDTORequest;
import com.froyo.app.model.dto.CurrencyEntityDTOResponse;
import com.froyo.app.model.entity.CurrencyEntity;
import com.froyo.app.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CurrencyRestController {

    @Qualifier("currencyMysqlServiceImpl")
    private final CurrencyService currencyMysqlServiceImpl;

    @PostMapping("/saveCurrency")
    private CurrencyEntityDTOResponse saveCurrency(@RequestBody CurrencyEntityDTORequest dtoRequest) {

        CurrencyEntityDTOResponse result = new CurrencyEntityDTOResponse();
        result.setCurrencyEntityDTORequest(dtoRequest);

        CurrencyEntityDTOResponse dtoResponseAux = currencyMysqlServiceImpl.saveCurrency(dtoRequest);
        result.getMessagePairList().addAll(dtoResponseAux.getMessagePairList());

        return result;
    }

    @GetMapping("/retrieveCurrency/{id}")
    private CurrencyEntity retrieveCurrency(@PathVariable("id") long id) {
        Optional<CurrencyEntity> optionalCurrencyEntity = currencyMysqlServiceImpl.retrieveCurrency(id);
        return optionalCurrencyEntity.orElse(null);
    }


}
