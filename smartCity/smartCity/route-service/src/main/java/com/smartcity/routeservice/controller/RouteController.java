package com.smartcity.routeservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartcity.routeservice.model.Route;
import com.smartcity.routeservice.model.RouteStop;
import com.smartcity.routeservice.repository.RouteRepository;
import com.smartcity.routeservice.repository.RouteStopRepository;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteRepository routeRepository;
    private final RouteStopRepository routeStopRepository;
    
    public RouteController(RouteRepository routeRepository, RouteStopRepository routeStopRepository) {
        this.routeRepository = routeRepository;
        this.routeStopRepository = routeStopRepository;
    }
    @GetMapping
    public List<Route> getRoutes(@RequestParam("mode") Route.Mode mode,
                                 @RequestParam("active") boolean active) {
        return routeRepository.findByModeAndActive(mode, active);
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable String id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
    }

    @GetMapping("/{id}/stops")
    public List<RouteStop> getRouteStops(@PathVariable String id) {
        return routeStopRepository.findByRouteIdOrderBySequenceAsc(id);
    }
}
