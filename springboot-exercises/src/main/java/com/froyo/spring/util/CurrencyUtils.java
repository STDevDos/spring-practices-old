package com.froyo.spring.util;

import java.util.Currency;
import java.util.Locale;

interface CurrencyUtils {

    static String getSymbol(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        return currency.getSymbol(locale);
    }

}
