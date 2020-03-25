package com.froyo.app.restcontroller;

import com.froyo.app.model.dto.CurrencyRequest;
import com.froyo.app.model.dto.CurrencyResponse;
import com.froyo.app.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CurrencyRestController {

    @Qualifier("currencyPostgresServiceImpl")
    private final CurrencyService currencyPostgresService;

    @Qualifier("currencyMysqlServiceImpl")
    private final CurrencyService currencyMysqlServiceImpl;

    @Qualifier("currencyH2ServiceImpl")
    private final CurrencyService currencyH2Service;

    @PostMapping("/addCurrency")
    private CurrencyResponse addCurrency(@RequestBody CurrencyRequest currencyRequest) {

        CurrencyResponse result = new CurrencyResponse();
        result.setCurrencyRequest(currencyRequest);

        CurrencyResponse currencyResponseP = currencyPostgresService.saveCurrency(currencyRequest);
        result.getMessagePairList().addAll(currencyResponseP.getMessagePairList());

        CurrencyResponse currencyResponseM = currencyMysqlServiceImpl.saveCurrency(currencyRequest);
        result.getMessagePairList().addAll(currencyResponseM.getMessagePairList());

        CurrencyResponse currencyResponseH = currencyH2Service.saveCurrency(currencyRequest);
        result.getMessagePairList().addAll(currencyResponseH.getMessagePairList());

        return result;
    }

}
