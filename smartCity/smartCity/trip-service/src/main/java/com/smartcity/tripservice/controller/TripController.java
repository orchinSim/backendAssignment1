package com.smartcity.tripservice.controller;

import com.smartcity.tripservice.model.Trip;
import com.smartcity.tripservice.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService service;

    public TripController(TripService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return service.getAllTrips();
    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable String id) {
        return service.getTripById(id);
    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return service.createTrip(trip);
    }
}
