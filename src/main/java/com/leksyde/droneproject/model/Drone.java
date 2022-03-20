package com.leksyde.droneproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Drone extends AbstractEntity  {

    @NotNull
    @Length(max = 100, message = "Maximum 100 characters")
    private String serialNumber;

    @NotNull
    private DroneModel model;

    @NotNull
    @Max(value=500, message = "Maximum 500g")
    private double weight;

    @NotNull
    private double batteryCapacity;

    @NotNull
    private State state;










    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "drone")
    private Set<Medication> medications = new HashSet<>();



    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setModel(DroneModel model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<Medication> getMedications() {
        return medications;
    }

    public void setMedications(Set<Medication> medications) {
        this.medications = medications;
    }

    public double totalCurrentWeight(){
        double sum = 0;
        for (Medication medication1 : this.getMedications()) {
            double weight = medication1.getWeight();
            sum += weight;
        }
        return sum;
    }

}
