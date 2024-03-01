package com.example.statisticsapi.repository;

import com.example.statisticsapi.document.SalesAndTrafficByDate;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAndTrafficByDateRepository
        extends MongoRepository<SalesAndTrafficByDate, String> {
    Optional<SalesAndTrafficByDate> findByDate(LocalDate date);
}
