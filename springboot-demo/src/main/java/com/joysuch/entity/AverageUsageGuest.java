package com.joysuch.entity;

import java.io.Serializable;

public class AverageUsageGuest implements Serializable {


    private String id;

    private String pname;

    private Double consumption;

    private Double balance;

    private Integer ispoor;

    public AverageUsageGuest() {

    }

    public AverageUsageGuest(String id, String pname, Double consumption, Double balance, Integer ispoor) {
        this.id = id;
        this.pname = pname;
        this.consumption = consumption;
        this.balance = balance;
        this.ispoor = ispoor;
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

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getIspoor() {
        return ispoor;
    }

    public void setIspoor(Integer ispoor) {
        this.ispoor = ispoor;
    }


}
