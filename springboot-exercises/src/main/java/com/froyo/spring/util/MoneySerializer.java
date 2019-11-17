package com.froyo.spring.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

/**
 * How to use:
 *
 * "@ JsonSerialize(using = MoneySerializer.class)"
 * private BigDecimal amount;
 * <p>
 * https://www.boraji.com/java-currency-class-example
 */
@SuppressWarnings("unused")
class MoneySerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        //String amount = String.format("%,.2f", value.setScale(2, RoundingMode.HALF_UP));

        String currencyCode = CurrencyUtils.getSymbol(Locale.JAPAN);
        String amount = String.format(Locale.JAPAN, "%(.2f", value.setScale(2, RoundingMode.HALF_UP));
        jgen.writeString(currencyCode + " " + amount);
    }
}
