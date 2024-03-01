package com.example.statisticsapi.service.initializer;

import com.example.statisticsapi.document.Report;
import com.example.statisticsapi.document.SalesAndTrafficByAsin;
import com.example.statisticsapi.document.SalesAndTrafficByDate;
import com.example.statisticsapi.dto.external.ReportSpecificationDto;
import com.example.statisticsapi.repository.ReportRepository;
import com.example.statisticsapi.repository.SalesAndTrafficByAsinRepository;
import com.example.statisticsapi.repository.SalesAndTrafficByDateRepository;
import com.example.statisticsapi.service.file.FileReaderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {
    public static final String FILE_PATH = "src/main/resources/static/test_report.json";
    public static final int FIRST_INDEX = 0;
    public static final String ERROR_MESSAGE = "Can't process JSON.";

    private final FileReaderService fileReaderService;
    private final ObjectMapper objectMapper;
    private final ReportRepository reportRepository;
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;
    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;

    @PostConstruct
    private void init() {
        Report entity = getReport();

        salesAndTrafficByDateRepository.saveAll(entity.getSalesAndTrafficByDate());
        salesAndTrafficByAsinRepository.saveAll(entity.getSalesAndTrafficByAsin());
        reportRepository.save(entity);
    }

    @Scheduled(fixedRate = 15,timeUnit = TimeUnit.MINUTES)
    public void update() {
        Report entity = getReport();

        ReportSpecificationDto reportSpecification = entity.getReportSpecification();
        Optional<Report> existingReport = reportRepository
                .findByReportSpecification(reportSpecification);

        existingReport.ifPresent(report -> entity.setId(report.getId()));

        for (SalesAndTrafficByDate salesAndTrafficByDate : entity.getSalesAndTrafficByDate()) {
            Optional<SalesAndTrafficByDate> optionalSalesAndTrafficByDate
                    = salesAndTrafficByDateRepository.findByDate(salesAndTrafficByDate.getDate());

            optionalSalesAndTrafficByDate
                    .ifPresent(data -> salesAndTrafficByDate.setId(data.getId()));

            salesAndTrafficByDateRepository.save(salesAndTrafficByDate);
        }

        for (SalesAndTrafficByAsin salesAndTrafficByAsin : entity.getSalesAndTrafficByAsin()) {
            Optional<SalesAndTrafficByAsin> existingSalesData = salesAndTrafficByAsinRepository
                    .findByParentAsin(salesAndTrafficByAsin.getParentAsin());

            existingSalesData
                    .ifPresent(data -> salesAndTrafficByAsin.setId(data.getId()));

            salesAndTrafficByAsinRepository.save(salesAndTrafficByAsin);
        }

        reportRepository.save(entity);
    }

    private Report getReport() {
        List<String> strings = fileReaderService.readFromFile(FILE_PATH);
        Report entity;
        try {
            entity = objectMapper.readValue(strings.get(FIRST_INDEX), Report.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(ERROR_MESSAGE, e);
        }
        return entity;
    }
}
