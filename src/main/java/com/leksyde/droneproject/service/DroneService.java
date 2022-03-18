package com.leksyde.droneproject.service;

import com.leksyde.droneproject.model.Drone;
import com.leksyde.droneproject.repo.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DroneService {

    private DroneRepository droneRepository;

    public DroneService(@Autowired DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }


    public Drone createDrone(Drone entity) {
        return droneRepository.save(entity);
    }

    public void delete(long id) {
        droneRepository.deleteById(id);
    }

    public List<Drone> list() {
        return droneRepository.findAll();
    }

    public int count() {
        return (int) droneRepository.count();
    }


}
