package com.example.statisticsapi.repository;

import com.example.statisticsapi.document.SalesAndTrafficByAsin;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAndTrafficByAsinRepository
        extends MongoRepository<SalesAndTrafficByAsin, String> {
    Optional<SalesAndTrafficByAsin> findByParentAsin(String parentAsin);
}
