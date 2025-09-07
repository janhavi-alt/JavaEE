package com.example.converter;

import jakarta.ejb.Local;
import java.math.BigDecimal;

@Local
public interface CurrencyConverterBeanLocal {
    /**
     * Convert amount from sourceCurrency -> targetCurrency.
     * Currency codes are ISO (e.g. "USD", "INR", "EUR").
     */
    BigDecimal convert(String sourceCurrency, String targetCurrency, BigDecimal amount);
}
