package com.smartcity.routeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stop {
    @Id
    private String id;

    private String name;

    private double lat;

    private double lon;

    private String code;
}
