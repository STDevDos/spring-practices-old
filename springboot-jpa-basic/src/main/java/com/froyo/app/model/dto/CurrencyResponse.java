package com.froyo.app.model.dto;

import com.froyo.messages.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * https://stackoverflow.com/questions/38572566/warning-equals-hashcode-on-data-annotation-lombok-with-inheritance
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CurrencyResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    CurrencyRequest currencyRequest = new CurrencyRequest();

}
