package com.leksyde.droneproject.service;

import com.leksyde.droneproject.model.Drone;
import com.leksyde.droneproject.model.Medication;
import com.leksyde.droneproject.repo.DroneRepository;
import com.leksyde.droneproject.repo.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    private MedicationRepository repository;

    public MedicationService(@Autowired MedicationRepository repository) {
        this.repository = repository;
    }


    public Medication update(Medication entity) {
        return repository.save(entity);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Medication> list() {
        return repository.findAll();
    }

    public int count() {
        return (int) repository.count();
    }
}
