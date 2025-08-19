package com.smartcity.tripservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Trip {

    @Id
    private String id;

    private String routeId;
    private String vehicleId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status; // e.g., scheduled, running, completed

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    // Getters and Setters
    // Constructors
}
