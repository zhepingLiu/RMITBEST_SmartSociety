package com.joysuch.entity;

import java.io.Serializable;

public class RealTimeUsage implements Serializable {

    private String pid;
    private String id;
    private String pname;
    private String timeperiod;
    private Double water;
    private Double power;
    private Double gas;
    private int ishome;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTimeperiod() {
        return timeperiod;
    }

    public void setTimeperiod(String timeperiod) {
        this.timeperiod = timeperiod;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getGas() {
        return gas;
    }

    public void setGas(Double gas) {
        this.gas = gas;
    }

    public int getIshome() {
        return ishome;
    }

    public void setIshome(int ishome) {
        this.ishome = ishome;
    }

    public RealTimeUsage(String pid, String id, String pname, String timeperiod, Double water, Double power, Double gas, int ishome) {
        this.pid = pid;
        this.id = id;
        this.pname = pname;
        this.timeperiod = timeperiod;
        this.water = water;
        this.power = power;
        this.gas = gas;
        this.ishome = ishome;
    }

    public RealTimeUsage() {
    }
}
