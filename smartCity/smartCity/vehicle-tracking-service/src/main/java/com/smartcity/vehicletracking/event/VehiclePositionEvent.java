package com.smartcity.vehicletracking.event;

import lombok.*;
import java.time.Instant;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class VehiclePositionEvent {
  private String vehicleId;
  private String routeId;
  private Instant ts;
  private double lat;
  private double lon;
  private Double speed;
  private Integer heading;
}
