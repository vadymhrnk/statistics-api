package com.example.statisticsapi.repository;

import com.example.statisticsapi.document.Report;
import com.example.statisticsapi.dto.external.ReportSpecificationDto;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
    Optional<Report> findByReportSpecification(ReportSpecificationDto reportSpecification);
}
