package com.smartcity.vehicletracking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    private String id;   // telemetryId or vehicleId

    @OneToOne(cascade = CascadeType.ALL)
    private VehicleStatus status;
    
 // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public VehicleStatus getStatus() { return status; }
    public void setStatus(VehicleStatus status) { this.status = status; }
}
