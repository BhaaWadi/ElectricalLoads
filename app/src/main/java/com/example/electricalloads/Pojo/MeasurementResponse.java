package com.example.electricalloads.Pojo;

public class MeasurementResponse {

    int statusCode;

    public MeasurementResponse() {
    }

    public MeasurementResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
