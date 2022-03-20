package com.leksyde.droneproject.exception;

public class DroneBatteryLowException extends RuntimeException {
    public DroneBatteryLowException(String message) {
        super(message);
    }

    public DroneBatteryLowException(String message, Throwable cause) {
        super(message, cause);
    }
}
