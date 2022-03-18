package com.leksyde.droneproject.repo;

import com.leksyde.droneproject.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}