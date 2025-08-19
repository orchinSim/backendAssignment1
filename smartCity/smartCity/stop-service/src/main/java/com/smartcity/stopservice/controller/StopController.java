package com.smartcity.stopservice.controller;

import com.smartcity.stopservice.entity.Stop;
import com.smartcity.stopservice.service.StopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stops")
public class StopController {

    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public List<Stop> getAllStops() {
        return stopService.getAllStops();
    }

    @GetMapping("/{id}")
    public Stop getStopById(@PathVariable String id) {
        return stopService.getStopById(id);
    }

    @PostMapping
    public Stop createStop(@RequestBody Stop stop) {
        return stopService.createStop(stop);
    }
}
