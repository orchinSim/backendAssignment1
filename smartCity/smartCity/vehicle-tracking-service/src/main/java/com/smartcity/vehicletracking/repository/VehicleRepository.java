package com.smartcity.vehicletracking.repository;

import com.smartcity.vehicletracking.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}

