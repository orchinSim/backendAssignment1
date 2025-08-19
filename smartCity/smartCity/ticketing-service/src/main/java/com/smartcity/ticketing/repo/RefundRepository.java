package com.smartcity.ticketing.repo;

import com.smartcity.ticketing.model.Refund;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RefundRepository extends MongoRepository<Refund, String> {}
