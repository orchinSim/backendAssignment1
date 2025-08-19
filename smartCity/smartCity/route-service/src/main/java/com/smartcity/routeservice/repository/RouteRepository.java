package com.smartcity.routeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcity.routeservice.model.Route;

public interface RouteRepository extends JpaRepository<Route, String> {
    List<Route> findByModeAndActive(Route.Mode mode, boolean active);
}
