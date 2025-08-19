package com.smartcity.stopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcity.stopservice.entity.Stop;

public interface StopRepository extends JpaRepository<Stop, String> {

}

