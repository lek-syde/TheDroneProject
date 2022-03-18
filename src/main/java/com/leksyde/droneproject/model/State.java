package com.leksyde.droneproject.model;

public enum State {
    IDLE("idle"), LOADING("loading"), LOADED("loaded"), DELIVERING("delivering"), DELIVERED("delivered"), RETURNING("returning") ;


    private String state;

     State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
