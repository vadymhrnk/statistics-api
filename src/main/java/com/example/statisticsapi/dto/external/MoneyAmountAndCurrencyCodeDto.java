package com.example.statisticsapi.dto.external;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class MoneyAmountAndCurrencyCodeDto {
    private BigDecimal amount;
    private CurrencyCode currencyCode;

    public enum CurrencyCode {
        USD
    }
}
