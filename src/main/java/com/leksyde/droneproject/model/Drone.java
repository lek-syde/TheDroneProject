package com.leksyde.droneproject.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Drone extends AbstractEntity  {

    @NotNull
    @Length(max = 100, message = "Maximum 100 characters")
    private String serialNumber;

    @NotNull
    private String model;

    @NotNull
    @Max(value=500, message = "Maximum 500g")
    private double weight;

    @NotNull
    private double batteryCapacity;

    @NotNull
    private State state;




}
