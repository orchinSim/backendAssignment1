package com.smartcity.routeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcity.routeservice.model.Stop;

public interface StopRepository extends JpaRepository<Stop, String> {

}
