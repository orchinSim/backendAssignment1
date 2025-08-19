package com.smartcity.vehicletracking.repository;

import com.smartcity.vehicletracking.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> { }
