package com.smartcity.agency.service;

import com.smartcity.agency.model.Agency;
import com.smartcity.agency.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public Agency saveAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    @Override
    public Agency getAgencyById(String id) {
        return agencyRepository.findById(id).orElse(null);
    }
}
