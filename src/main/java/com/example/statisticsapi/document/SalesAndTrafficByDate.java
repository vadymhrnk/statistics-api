package com.example.statisticsapi.document;

import com.example.statisticsapi.dto.external.SalesByDateDto;
import com.example.statisticsapi.dto.external.TrafficByDateDto;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SalesAndTrafficByDate {
    @Id
    private String id;
    private LocalDate date;
    private SalesByDateDto salesByDate;
    private TrafficByDateDto trafficByDate;
}
