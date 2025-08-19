package com.smartcity.vehicletracking.event;

import lombok.*;
import java.time.Instant;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class DelayDetectedEvent {
  private String vehicleId;
  private String routeId;
  private Integer delaySec;
  private String basedOn;  // e.g., "interval"
  private Instant ts;
}
