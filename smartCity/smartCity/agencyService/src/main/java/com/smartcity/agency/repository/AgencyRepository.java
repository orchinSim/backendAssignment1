package com.smartcity.agency.repository;

import com.smartcity.agency.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, String> {
}
