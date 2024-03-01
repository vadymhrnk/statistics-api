package com.example.statisticsapi.document;

import com.example.statisticsapi.dto.external.ReportSpecificationDto;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Report {
    @Id
    private String id;
    private ReportSpecificationDto reportSpecification;
    @DBRef
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    @DBRef
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
