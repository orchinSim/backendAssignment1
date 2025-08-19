package com.smartcity.ticketing.repo;

import com.smartcity.ticketing.model.Validation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ValidationRepository extends MongoRepository<Validation, String> {
    Optional<Validation> findByRequestId(String requestId);
}
