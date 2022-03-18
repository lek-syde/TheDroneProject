package com.leksyde.droneproject.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Drone extends AbstractEntity  {

    @NotNull
    private String serialNumber;
    @NotNull
    private String model;
    @NotNull
    private double weight;
    @NotNull
    private double batteryCapacity;
    @NotNull
    private State state;




}
