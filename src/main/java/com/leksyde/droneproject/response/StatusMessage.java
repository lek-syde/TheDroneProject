package com.leksyde.droneproject.response;

public class StatusMessage {
    String message;
    int statusCode;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public StatusMessage(int statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
