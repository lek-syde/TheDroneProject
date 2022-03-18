package com.leksyde.droneproject.repo;

import com.leksyde.droneproject.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
}