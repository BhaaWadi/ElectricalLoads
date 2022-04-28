package com.example.electricalloads.Pojo;

import java.util.ArrayList;

public class ReadingResponse {

    private ArrayList<Reading> readingArrayList;
    private double percentageFaz;
    private double average_loading_percentage;

    public ReadingResponse() {
    }

    public ReadingResponse(ArrayList<Reading> readingArrayList, double percentageFaz, double average_loading_percentage) {
        this.readingArrayList = readingArrayList;
        this.percentageFaz = percentageFaz;
        this.average_loading_percentage = average_loading_percentage;
    }

    public ArrayList<Reading> getReadingArrayList() {
        return readingArrayList;
    }

    public void setReadingArrayList(ArrayList<Reading> readingArrayList) {
        this.readingArrayList = readingArrayList;
    }

    public double getPercentageFaz() {
        return percentageFaz;
    }

    public void setPercentageFaz(double percentageFaz) {
        this.percentageFaz = percentageFaz;
    }

    public double getAverage_loading_percentage() {
        return average_loading_percentage;
    }

    public void setAverage_loading_percentage(double average_loading_percentage) {
        this.average_loading_percentage = average_loading_percentage;
    }
}
