package com.smartcity.vehicletracking.repository;

import com.smartcity.vehicletracking.model.VehiclePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VehiclePositionRepository extends JpaRepository<VehiclePosition, Long> {
  // Use the correct field name from VehiclePosition: "timestamp"
  Optional<VehiclePosition> findTopByVehicle_IdOrderByTimestampDesc(String vehicleId);
}
