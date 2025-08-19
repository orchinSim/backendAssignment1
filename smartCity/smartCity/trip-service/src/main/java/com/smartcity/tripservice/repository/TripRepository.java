package com.smartcity.tripservice.repository;

import com.smartcity.tripservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, String> {
}
