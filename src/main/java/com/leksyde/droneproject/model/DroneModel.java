package com.leksyde.droneproject.model;

public enum DroneModel {

    Lightweight("Lightweight"), Middleweight("Middleweight"), Cruiserweight("Cruiserweight"), Heavyweight("Heavyweight");

    private String model;

    DroneModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
