package com.smartcity.routeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcity.routeservice.model.RouteStop;
import com.smartcity.routeservice.model.RouteStopId;

public interface RouteStopRepository extends JpaRepository<RouteStop, RouteStopId> {
    List<RouteStop> findByRouteIdOrderBySequenceAsc(String routeId);
}
