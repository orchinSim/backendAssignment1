package com.smartcity.routeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Mode mode;

    private boolean active;

    private String agencyId;

    public enum Mode {
        BUS,
        TRAIN
    }
}
