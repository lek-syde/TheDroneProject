package com.leksyde.droneproject.controller;

import com.leksyde.droneproject.exception.DroneBatteryLowException;
import com.leksyde.droneproject.exception.DroneNotFoundException;
import com.leksyde.droneproject.exception.DroneOverloadedException;
import com.leksyde.droneproject.model.Drone;
import com.leksyde.droneproject.model.Medication;
import com.leksyde.droneproject.model.State;
import com.leksyde.droneproject.response.StatusMessage;
import com.leksyde.droneproject.service.DroneService;
import com.leksyde.droneproject.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DroneController {

    @Autowired
    DroneService droneService;

    @Autowired
    MedicationService medicationService;



    @PutMapping("/drone")
    public ResponseEntity<StatusMessage> loadDrone(@RequestBody Drone drone){

        droneService.updateDrone(drone);

        return new ResponseEntity<>(new StatusMessage(200, "Drone successfully added"), HttpStatus.OK);

    }

    @GetMapping("/drone")
    public Drone loadDrone( @RequestParam long id){


        if(!droneService.findById(id).isPresent()){
            throw new DroneNotFoundException("Drone not found");
        }


        return droneService.findById(id).get();

    }

    @GetMapping("/drones")
    public List<Drone> showAlldrone(){

        return droneService.findAll();

    }


    @PutMapping("/drone/{id}")
    public void updateMedication(@RequestBody Medication medication, @PathVariable long id){

        if(!droneService.findById(id).isPresent()){
            throw new DroneNotFoundException("Drone not found");
        }

        Drone drone= droneService.findById(id).get();
        double loadingWeight=drone.totalCurrentWeight()+medication.getWeight();

        if(loadingWeight>drone.getWeight()){
            throw new DroneOverloadedException("Drone would be overloaded: cannot load medication");
        }

        if(drone.getBatteryCapacity()<25){
            throw new DroneBatteryLowException("Drone cannot load: Battery low");
        }


        drone.setState(State.LOADING);
        droneService.updateDrone(drone);

        medication.setDrone(droneService.findById(id).get());
        medicationService.update(medication);


        drone.setState(State.LOADED);
        droneService.updateDrone(drone);

    }

    @GetMapping("/search-drone")
    public List<Drone> availableDrone(@RequestParam String state){

        switch (state){

            case "IDLE":
                return droneService.findByState(State.IDLE);

            case "LOADING":
                return droneService.findByState(State.LOADING);

            case "LOADED":
                return droneService.findByState(State.LOADED);

            case "DELIVERING":
                return droneService.findByState(State.DELIVERING);

            case "DELIVERED":
                return droneService.findByState(State.DELIVERED);

            case "RETURNING":
                return droneService.findByState(State.RETURNING);

            default:
               return droneService.findAll();


        }

    }






}
