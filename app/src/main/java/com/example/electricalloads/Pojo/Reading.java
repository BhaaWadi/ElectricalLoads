package com.example.electricalloads.Pojo;

import java.io.Serializable;

public class Reading implements Serializable {


    private  int ser;
    private  int ser_det;

    private   int id_ElectricConverter;
    private  int dir_skina;
    private  double power_skina;

    private  double R;
    private  double S;
    private  double T;
    private  double N;
    private  double RS;
    private  double RT;
    private  double ST;
    private  double RN;
    private  double SN;
    private  double TN;
    private int entry_user;
    private long entry_date;
    private int update_user;
    private int update_date;
    public Reading() {
    }

    public Reading(int ser, int id_ElectricConverter, int dir_skina, double power_skina, double r, double s, double t, double n, double RS, double RT, double ST, double RN, double SN, double TN, int entry_user, long entry_date) {
        this.ser = ser;
        this.id_ElectricConverter = id_ElectricConverter;
        this.dir_skina = dir_skina;
        this.power_skina = power_skina;
        R = r;
        S = s;
        T = t;
        N = n;
        this.RS = RS;
        this.RT = RT;
        this.ST = ST;
        this.RN = RN;
        this.SN = SN;
        this.TN = TN;
        this.entry_user = entry_user;
        this.entry_date = entry_date;
    }

    public int getSer() {
        return ser;
    }

    public void setSer(int ser) {
        this.ser = ser;
    }

    public int getSer_det() {
        return ser_det;
    }

    public void setSer_det(int ser_det) {
        this.ser_det = ser_det;
    }

    public int getId_ElectricConverter() {
        return id_ElectricConverter;
    }

    public void setId_ElectricConverter(int id_ElectricConverter) {
        this.id_ElectricConverter = id_ElectricConverter;
    }

    public int getDir_skina() {
        return dir_skina;
    }

    public void setDir_skina(int dir_skina) {
        this.dir_skina = dir_skina;
    }

    public double getPower_skina() {
        return power_skina;
    }

    public void setPower_skina(double power_skina) {
        this.power_skina = power_skina;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public double getS() {
        return S;
    }

    public void setS(double s) {
        S = s;
    }

    public double getT() {
        return T;
    }

    public void setT(double t) {
        T = t;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    public double getRS() {
        return RS;
    }

    public void setRS(double RS) {
        this.RS = RS;
    }

    public double getRT() {
        return RT;
    }

    public void setRT(double RT) {
        this.RT = RT;
    }

    public double getST() {
        return ST;
    }

    public void setST(double ST) {
        this.ST = ST;
    }

    public double getRN() {
        return RN;
    }

    public void setRN(double RN) {
        this.RN = RN;
    }

    public double getSN() {
        return SN;
    }

    public void setSN(double SN) {
        this.SN = SN;
    }

    public double getTN() {
        return TN;
    }

    public void setTN(double TN) {
        this.TN = TN;
    }

    public int getEntry_user() {
        return entry_user;
    }

    public void setEntry_user(int entry_user) {
        this.entry_user = entry_user;
    }

    public long getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(long entry_date) {
        this.entry_date = entry_date;
    }

    public int getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(int update_user) {
        this.update_user = update_user;
    }

    public int getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(int update_date) {
        this.update_date = update_date;
    }
}
