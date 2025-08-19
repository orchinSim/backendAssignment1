package com.smartcity.vehicletracking.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelemetryRequest {
    private String telemetryId;
    private double lat;
    private double lon;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    
 // getters and setters
    public String getTelemetryId() { return telemetryId; }
    public void setTelemetryId(String telemetryId) { this.telemetryId = telemetryId; }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }

    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
