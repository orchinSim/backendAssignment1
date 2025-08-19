package com.smartcity.vehicletracking.controller;

import com.smartcity.vehicletracking.dto.TelemetryRequest;
import com.smartcity.vehicletracking.service.VehicleTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;   //  FIX: import this
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleTrackingService trackingService;

    @Autowired
    public VehicleController(VehicleTrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @PostMapping("/telemetry")
    public ResponseEntity<String> processTelemetry(@RequestBody TelemetryRequest request) {
        trackingService.processTelemetry(request);   //  use trackingService (not vehicleTrackingService)
        return ResponseEntity.ok("Telemetry processed successfully"); // ✅ return a response
    }
}
