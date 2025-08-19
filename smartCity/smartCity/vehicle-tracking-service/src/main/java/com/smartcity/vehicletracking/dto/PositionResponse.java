package com.smartcity.vehicletracking.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor
@Builder
public class PositionResponse {
  private String vehicleId;
  private Instant ts;
  private double lat;
  private double lon;
  private Double speed;
  private Integer heading;
  private Double accuracyM;
}
