package com.smartcity.tripservice.service;

import com.smartcity.tripservice.model.Trip;
import com.smartcity.tripservice.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository repository;

    public TripService(TripRepository repository) {
        this.repository = repository;
    }

    public List<Trip> getAllTrips() {
        return repository.findAll();
    }

    public Trip createTrip(Trip trip) {
        return repository.save(trip);
    }

    public Trip getTripById(String id) {
        return repository.findById(id).orElse(null);
    }
}
