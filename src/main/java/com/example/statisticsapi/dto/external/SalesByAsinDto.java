package com.example.statisticsapi.dto.external;

import lombok.Data;

@Data
public class SalesByAsinDto {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private MoneyAmountAndCurrencyCodeDto orderedProductSales;
    private MoneyAmountAndCurrencyCodeDto orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
}
