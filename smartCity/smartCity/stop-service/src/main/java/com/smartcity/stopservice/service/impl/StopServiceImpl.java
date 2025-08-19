package com.smartcity.stopservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcity.stopservice.entity.Stop;
import com.smartcity.stopservice.repository.StopRepository;
import com.smartcity.stopservice.service.StopService;

@Service
public class StopServiceImpl implements StopService {

    private final StopRepository stopRepository;

    public StopServiceImpl(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @Override
    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }

    @Override
    public Stop getStopById(String id) {
        return stopRepository.findById(id).orElse(null);
    }

    @Override
    public Stop createStop(Stop stop) {
        return stopRepository.save(stop);
    }
}
