package com.example.statisticsapi.dto.external;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class ReportSpecificationDto {
    private String reportType;
    private ReportOptionsDto reportOptions;
    private LocalDate dataStartTime;
    private LocalDate dataEndTime;
    private List<String> marketplaceIds;
}
