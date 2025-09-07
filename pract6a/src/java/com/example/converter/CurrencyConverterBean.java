package com.example.converter;

import jakarta.ejb.Stateless;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.HashMap;

@Stateless
public class CurrencyConverterBean implements CurrencyConverterBeanLocal {

    // Simple hard-coded rates relative to USD for demo.
    // In real app, fetch from an API or DB.
    private static final Map<String, BigDecimal> RATE_TO_USD = new HashMap<>();
    static {
        RATE_TO_USD.put("USD", BigDecimal.valueOf(1.0));       // base
        RATE_TO_USD.put("EUR", BigDecimal.valueOf(0.92));      // 1 EUR = 0.92 USD (example)
        RATE_TO_USD.put("INR", BigDecimal.valueOf(0.012));     // 1 INR = 0.012 USD
        RATE_TO_USD.put("GBP", BigDecimal.valueOf(1.21));      // 1 GBP = 1.21 USD
        RATE_TO_USD.put("JPY", BigDecimal.valueOf(0.0064));    // 1 JPY = 0.0064 USD
    }

    @Override
    public BigDecimal convert(String sourceCurrency, String targetCurrency, BigDecimal amount) {
        if (sourceCurrency == null || targetCurrency == null || amount == null) {
            throw new IllegalArgumentException("Null arguments not allowed");
        }

        sourceCurrency = sourceCurrency.toUpperCase();
        targetCurrency = targetCurrency.toUpperCase();

        BigDecimal srcRate = RATE_TO_USD.get(sourceCurrency);
        BigDecimal tgtRate = RATE_TO_USD.get(targetCurrency);

        if (srcRate == null || tgtRate == null) {
            throw new IllegalArgumentException("Unsupported currency code");
        }

        // Convert: amount_in_usd = amount * srcRate
        BigDecimal amountInUSD = amount.multiply(srcRate);
        // then to target: converted = amountInUSD / tgtRate
        BigDecimal converted = amountInUSD.divide(tgtRate, 6, RoundingMode.HALF_UP);

        // Round to 2 decimal places for display
        return converted.setScale(2, RoundingMode.HALF_UP);
    }
}
