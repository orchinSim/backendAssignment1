package com.smartcity.agency.controller;

import com.smartcity.agency.model.Agency;
import com.smartcity.agency.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencies")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @PostMapping
    public Agency createAgency(@RequestBody Agency agency) {
        return agencyService.saveAgency(agency);
    }

    @GetMapping
    public List<Agency> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    @GetMapping("/{id}")
    public Agency getAgencyById(@PathVariable String id) {
        return agencyService.getAgencyById(id);
    }
}
