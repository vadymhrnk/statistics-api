package com.example.statisticsapi.dto.external;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SalesAndTrafficByDateDto {
    private LocalDate date;
    private SalesByDateDto salesByDate;
    private TrafficByDateDto trafficByDate;
}
