package com.leksyde.droneproject.controller;

import com.leksyde.droneproject.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableAsync
public class DeamonController {



    @Autowired
    DroneService droneService;




    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {


        }




    }
