package com.example.statisticsapi.service.report;

import com.example.statisticsapi.dto.external.SalesAndTrafficByAsinDto;
import com.example.statisticsapi.dto.external.SalesAndTrafficByDateDto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ReportService {
    List<SalesAndTrafficByDateDto> findAllSalesAndTrafficByDate(Pageable pageable);

    List<SalesAndTrafficByAsinDto> findAllSalesAndTrafficByAsin(Pageable pageable);

    List<SalesAndTrafficByDateDto> findAllSalesAndTrafficBySelectedDates(
            Pageable pageable,
            LocalDate firstDate,
            LocalDate secondDate
    );

    List<SalesAndTrafficByAsinDto> findAllSalesAndTrafficBySelectedAsins(
            Pageable pageable,
            List<String> asinList
    );
}
