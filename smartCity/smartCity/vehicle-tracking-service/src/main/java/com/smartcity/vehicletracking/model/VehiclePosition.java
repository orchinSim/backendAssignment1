package com.smartcity.vehicletracking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VehiclePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double lat;
    private double lon;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public VehiclePosition() {}

    public VehiclePosition(Long id, double lat, double lon, LocalDateTime timestamp, Vehicle vehicle) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.timestamp = timestamp;
        this.vehicle = vehicle;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }

    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
