package com.leksyde.droneproject.service;

import com.leksyde.droneproject.model.Drone;
import com.leksyde.droneproject.model.State;
import com.leksyde.droneproject.repo.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DroneService {

    private DroneRepository droneRepository;

    public DroneService(@Autowired DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }


    public Drone updateDrone(Drone entity) {
        entity.setState(State.IDLE);
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

    public Optional<Drone> findById(long id){
      return  droneRepository.findById(id);
    }


    public List<Drone> findByState(State state){
        return  droneRepository.findByState(state);
    }

    public List<Drone> findAll() {
        return droneRepository.findAll();
    }
}
