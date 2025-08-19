package com.smartcity.vehicletracking.model;

import jakarta.persistence.*;

@Entity
public class VehicleStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String details;

    public VehicleStatus() {
    }

    public VehicleStatus(Long id, String status, String details) {
        this.id = id;
        this.status = status;
        this.details = details;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
