package com.example.statisticsapi.dto.external;

import lombok.Data;

@Data
public class SalesAndTrafficByAsinDto {
    private String parentAsin;
    private SalesByAsinDto salesByAsin;
    private TrafficByAsinDto trafficByAsin;
}
