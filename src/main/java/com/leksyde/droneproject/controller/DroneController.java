package com.leksyde.droneproject.controller;

import com.leksyde.droneproject.model.Drone;
import com.leksyde.droneproject.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneController {

    @Autowired
    DroneService droneService;

    @PostMapping("/postbody")
    public void loadDrone(@RequestBody Drone drone){
        droneService.createDrone(drone);


    }


}
