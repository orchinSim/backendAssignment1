package com.smartcity.routeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RouteStopId.class)
public class RouteStop {

    @Id
    private String routeId;

    @Id
    private String stopId;

    private int sequence;

    private int dwellSeconds;
}
