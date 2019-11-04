package com.exercises.spring.util;

import java.util.Currency;
import java.util.Locale;

public interface CurrencyUtils {

    static String getSymbol(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        return currency.getSymbol(locale);
    }

}
