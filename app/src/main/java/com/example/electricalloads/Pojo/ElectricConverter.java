package com.example.electricalloads.Pojo;

import android.provider.ContactsContract;

import java.io.Serializable;
import java.util.Date;

public class ElectricConverter implements Serializable {



  private   int id_material;

  private  String converterName;
  private  String  governorate;
  private Date lastReadDate;
  private double adapter_capacity;
  private String company_name;
  private int manufacturing;
  private double power;
  private double current_power;
  private double current_voltage;
  private String feed_line;
  private double percentageFAz;
  private double percentageAvg;
    private String nature_of_adapter_loads;

    public ElectricConverter() {
    }

    public ElectricConverter(int id_material, String converterName, String governorate, Date lastReadDate, double adapter_capacity, String company_name, int manufacturing, double power, double current_power, double current_voltage, String feed_line, double percentageFAz, double percentageAvg, String nature_of_adapter_loads) {
        this.id_material = id_material;
        this.converterName = converterName;
        this.governorate = governorate;
        this.lastReadDate = lastReadDate;
        this.adapter_capacity = adapter_capacity;
        this.company_name = company_name;
        this.manufacturing = manufacturing;
        this.power = power;
        this.current_power = current_power;
        this.current_voltage = current_voltage;
        this.feed_line = feed_line;
        this.percentageFAz = percentageFAz;
        this.percentageAvg = percentageAvg;
        this.nature_of_adapter_loads = nature_of_adapter_loads;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public String getConverterName() {
        return converterName;
    }

    public void setConverterName(String converterName) {
        this.converterName = converterName;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public Date getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate(Date lastReadDate) {
        this.lastReadDate = lastReadDate;
    }

    public double getAdapter_capacity() {
        return adapter_capacity;
    }

    public void setAdapter_capacity(double adapter_capacity) {
        this.adapter_capacity = adapter_capacity;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(int manufacturing) {
        this.manufacturing = manufacturing;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getCurrent_power() {
        return current_power;
    }

    public void setCurrent_power(double current_power) {
        this.current_power = current_power;
    }

    public double getCurrent_voltage() {
        return current_voltage;
    }

    public void setCurrent_voltage(double current_voltage) {
        this.current_voltage = current_voltage;
    }

    public String getFeed_line() {
        return feed_line;
    }

    public void setFeed_line(String feed_line) {
        this.feed_line = feed_line;
    }

    public double getPercentageFAz() {
        return percentageFAz;
    }

    public void setPercentageFAz(double percentageFAz) {
        this.percentageFAz = percentageFAz;
    }

    public double getPercentageAvg() {
        return percentageAvg;
    }

    public void setPercentageAvg(double percentageAvg) {
        this.percentageAvg = percentageAvg;
    }

    public String getNature_of_adapter_loads() {
        return nature_of_adapter_loads;
    }

    public void setNature_of_adapter_loads(String nature_of_adapter_loads) {
        this.nature_of_adapter_loads = nature_of_adapter_loads;
    }
}
