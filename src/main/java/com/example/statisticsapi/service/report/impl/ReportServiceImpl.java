package com.example.statisticsapi.service.report.impl;

import com.example.statisticsapi.dto.external.SalesAndTrafficByAsinDto;
import com.example.statisticsapi.dto.external.SalesAndTrafficByDateDto;
import com.example.statisticsapi.mapper.SalesAndTrafficByAsinMapper;
import com.example.statisticsapi.mapper.SalesAndTrafficByDateMapper;
import com.example.statisticsapi.repository.SalesAndTrafficByAsinRepository;
import com.example.statisticsapi.repository.SalesAndTrafficByDateRepository;
import com.example.statisticsapi.service.report.ReportService;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;
    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;
    private final SalesAndTrafficByDateMapper salesAndTrafficByDateMapper;
    private final SalesAndTrafficByAsinMapper salesAndTrafficByAsinMapper;

    @Cacheable(value = "reportCache")
    @Override
    public List<SalesAndTrafficByDateDto> findAllSalesAndTrafficByDate(Pageable pageable) {
        return salesAndTrafficByDateRepository.findAll(pageable).stream()
                .map(salesAndTrafficByDateMapper::toDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "reportCache")
    @Override
    public List<SalesAndTrafficByAsinDto> findAllSalesAndTrafficByAsin(Pageable pageable) {
        return salesAndTrafficByAsinRepository.findAll(pageable).stream()
                .map(salesAndTrafficByAsinMapper::toDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "reportCache")
    @Override
    public List<SalesAndTrafficByDateDto> findAllSalesAndTrafficBySelectedDates(
            Pageable pageable,
            LocalDate firstDate,
            LocalDate secondDate
    ) {

        Predicate<SalesAndTrafficByDateDto> salesAndTrafficByDatePredicate;
        if (firstDate.isAfter(secondDate)) {
            salesAndTrafficByDatePredicate = salesAndTrafficByDateDto -> {
                LocalDate date = salesAndTrafficByDateDto.getDate();
                return (date.isEqual(firstDate) || date.isBefore(firstDate))
                        & (date.isEqual(secondDate) || date.isAfter(secondDate));
            };
        } else {
            salesAndTrafficByDatePredicate = salesAndTrafficByDateDto -> {
                LocalDate date = salesAndTrafficByDateDto.getDate();
                return (date.isEqual(firstDate) || date.isAfter(firstDate))
                        & (date.isEqual(secondDate) || date.isBefore(secondDate));
            };
        }

        return salesAndTrafficByDateRepository.findAll(pageable).stream()
                .map(salesAndTrafficByDateMapper::toDto)
                .filter(salesAndTrafficByDatePredicate)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "reportCache")
    @Override
    public List<SalesAndTrafficByAsinDto> findAllSalesAndTrafficBySelectedAsins(
            Pageable pageable,
            List<String> asinList
    ) {
        return salesAndTrafficByAsinRepository.findAll(pageable).stream()
                .map(salesAndTrafficByAsinMapper::toDto)
                .filter(salesAndTrafficByDateDto -> asinList.contains(
                        salesAndTrafficByDateDto.getParentAsin()
                ))
                .collect(Collectors.toList());
    }

    @CacheEvict(value = "reportCache", allEntries = true)
    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
    public void clearCache() {
    }
}
