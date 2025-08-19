package com.smartcity.stopservice.service;

import java.util.List;

import com.smartcity.stopservice.entity.Stop;

public interface StopService {
    List<Stop> getAllStops();
    Stop getStopById(String id);
    Stop createStop(Stop stop);
}
