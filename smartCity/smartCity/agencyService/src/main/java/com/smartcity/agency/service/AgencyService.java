package com.smartcity.agency.service;

import com.smartcity.agency.model.Agency;
import java.util.List;

public interface AgencyService {
    Agency saveAgency(Agency agency);
    List<Agency> getAllAgencies();
    Agency getAgencyById(String id);
}
