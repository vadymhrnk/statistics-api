package com.example.statisticsapi.dto.external;

import lombok.Data;

@Data
public class ReportResponseDto {
    private ReportSpecificationDto reportSpecification;
    private SalesAndTrafficByDateDto salesAndTrafficByDate;
    private SalesAndTrafficByAsinDto salesAndTrafficByAsin;
}
