package com.joysuch.entity;

import java.io.Serializable;

public class AverageUsage implements Serializable {

    private String id;

    private String pname;

    private Double water;

    private Double power;

    private Double gas;



    public AverageUsage(){

    }


    public AverageUsage(String id, String pname, Double water, Double power, Double gas) {
        this.id = id;
        this.pname = pname;
        this.water = water;
        this.power = power;
        this.gas = gas;
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
}
