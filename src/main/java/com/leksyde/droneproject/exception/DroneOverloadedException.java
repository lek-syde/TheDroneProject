package com.leksyde.droneproject.exception;

public class DroneOverloadedException extends RuntimeException {
    public DroneOverloadedException(String message) {
        super(message);
    }

    public DroneOverloadedException(String message, Throwable cause) {
        super(message, cause);
    }
}

