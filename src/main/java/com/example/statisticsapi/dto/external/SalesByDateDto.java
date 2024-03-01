package com.example.statisticsapi.dto.external;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class SalesByDateDto {
    private MoneyAmountAndCurrencyCodeDto orderedProductSales;
    private MoneyAmountAndCurrencyCodeDto orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private MoneyAmountAndCurrencyCodeDto averageSalesPerOrderItem;
    private MoneyAmountAndCurrencyCodeDto averageSalesPerOrderItemB2B;
    private BigDecimal averageUnitsPerOrderItem;
    private BigDecimal averageUnitsPerOrderItemB2B;
    private MoneyAmountAndCurrencyCodeDto averageSellingPrice;
    private MoneyAmountAndCurrencyCodeDto averageSellingPriceB2B;
    private int unitsRefunded;
    private BigDecimal refundRate;
    private int claimsGranted;
    private MoneyAmountAndCurrencyCodeDto claimsAmount;
    private MoneyAmountAndCurrencyCodeDto shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;
}
