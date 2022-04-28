package com.example.electricalloads.Pojo;


import java.util.List;

public interface ReadingListener {


    void getReadingByElectricConverterID(List<Reading> list,double percentageFaz,double average_loading_percentage);
}
