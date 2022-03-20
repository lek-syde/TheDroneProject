package com.leksyde.droneproject.repo;

import com.leksyde.droneproject.model.Drone;
import com.leksyde.droneproject.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByState(State state);

}