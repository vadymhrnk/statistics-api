package com.example.statisticsapi.document;

import com.example.statisticsapi.dto.external.SalesByAsinDto;
import com.example.statisticsapi.dto.external.TrafficByAsinDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SalesAndTrafficByAsin {
    @Id
    private String id;
    private String parentAsin;
    private SalesByAsinDto salesByAsin;
    private TrafficByAsinDto trafficByAsin;
}
