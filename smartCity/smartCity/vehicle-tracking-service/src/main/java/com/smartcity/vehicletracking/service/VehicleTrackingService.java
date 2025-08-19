package com.smartcity.vehicletracking.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcity.vehicletracking.dto.TelemetryRequest;
import com.smartcity.vehicletracking.model.Vehicle;
import com.smartcity.vehicletracking.model.VehiclePosition;
import com.smartcity.vehicletracking.model.VehicleStatus;
import com.smartcity.vehicletracking.repository.VehiclePositionRepository;
import com.smartcity.vehicletracking.repository.VehicleRepository;
import com.smartcity.vehicletracking.repository.VehicleStatusRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VehicleTrackingService {

    private final VehicleRepository vehicleRepository;
    private final VehicleStatusRepository vehicleStatusRepository;
    private final VehiclePositionRepository vehiclePositionRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String TOPIC = "vehicle-telemetry";

    public VehicleTrackingService(VehicleRepository vehicleRepository,
                                  VehicleStatusRepository vehicleStatusRepository,
                                  VehiclePositionRepository vehiclePositionRepository,
                                  KafkaTemplate<String, String> kafkaTemplate,
                                  ObjectMapper objectMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleStatusRepository = vehicleStatusRepository;
        this.vehiclePositionRepository = vehiclePositionRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void processTelemetry(TelemetryRequest request) {
        // --- Save to DB ---
        Vehicle vehicle = new Vehicle();
        vehicle.setId(request.getTelemetryId());

        VehicleStatus status = new VehicleStatus();
        status.setStatus("ACTIVE");
        status.setDetails("Telemetry received");
        vehicle.setStatus(status);

        vehicleStatusRepository.save(status);
        vehicleRepository.save(vehicle);

        VehiclePosition position = new VehiclePosition();
        position.setLat(request.getLat());
        position.setLon(request.getLon());
        position.setTimestamp(request.getTimestamp());
        position.setVehicle(vehicle);

        vehiclePositionRepository.save(position);

        // --- Publish to Kafka ---
        try {
            String message = objectMapper.writeValueAsString(request);
            kafkaTemplate.send(TOPIC, request.getTelemetryId(), message);
            System.out.println("✅ Published to Kafka: " + message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize telemetry request", e);
        }
    }
}
