package com.example.statisticsapi.controller;

import com.example.statisticsapi.dto.external.SalesAndTrafficByAsinDto;
import com.example.statisticsapi.dto.external.SalesAndTrafficByDateDto;
import com.example.statisticsapi.service.report.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Report selector", description = "Endpoint for viewing reports")
@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/dates")
    @Operation(
            summary = "Get all reports by date",
            description = "Get a list of all reports by date"
    )
    public List<SalesAndTrafficByDateDto> getAllSalesAndTrafficByDate(Pageable pageable) {
        return reportService.findAllSalesAndTrafficByDate(pageable);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/ASIN")
    @Operation(
            summary = "Get all reports by ASIN",
            description = "Get a list of all by ASIN"
    )
    public List<SalesAndTrafficByAsinDto> getAllSalesAndTrafficByAsin(Pageable pageable) {
        return reportService.findAllSalesAndTrafficByAsin(pageable);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/dates", params = {"firstDate", "secondDate"})
    @Operation(
            summary = "Get all reports by selected dates",
            description = "Get a list of all by selected dates"
    )
    public List<SalesAndTrafficByDateDto> getAllSalesAndTrafficBySelectedDates(
            Pageable pageable,
            @RequestParam(required = false) LocalDate firstDate,
            @RequestParam(required = false) LocalDate secondDate
    ) {
        return reportService.findAllSalesAndTrafficBySelectedDates(pageable, firstDate, secondDate);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/ASIN", params = {"asinList"})
    @Operation(
            summary = "Get all reports by selected ASINs",
            description = "Get a list of all by selected ASINs"
    )
    public List<SalesAndTrafficByAsinDto> getAllSalesAndTrafficBySelectedAsins(
            Pageable pageable,
            @RequestParam(required = false) List<String> asinList) {
        return reportService.findAllSalesAndTrafficBySelectedAsins(pageable, asinList);
    }
}

