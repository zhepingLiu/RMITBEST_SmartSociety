package com.joysuch.entity;

import java.io.Serializable;

public class Prediction implements Serializable {

    private String id;

    private Integer ispoorprediction;

    private Double ispoorprob;

    private Integer ishomeprediction;

    private Double ishomeprob;

    public Prediction(String id, Integer ispoorprediction, Double ispoorprob, Integer ishomeprediction, Double ishomeprob) {
        this.id = id;
        this.ispoorprediction = ispoorprediction;
        this.ispoorprob = ispoorprob;
        this.ishomeprediction = ishomeprediction;
        this.ishomeprob = ishomeprob;
    }

    public Prediction() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIspoorprediction() {
        return ispoorprediction;
    }

    public void setIspoorprediction(Integer ispoorprediction) {
        this.ispoorprediction = ispoorprediction;
    }

    public Double getIspoorprob() {
        return ispoorprob;
    }

    public void setIspoorprob(Double ispoorprob) {
        this.ispoorprob = ispoorprob;
    }

    public Integer getIshomeprediction() {
        return ishomeprediction;
    }

    public void setIshomeprediction(Integer ishomeprediction) {
        this.ishomeprediction = ishomeprediction;
    }

    public Double getIshomeprob() {
        return ishomeprob;
    }

    public void setIshomeprob(Double ishomeprob) {
        this.ishomeprob = ishomeprob;
    }
}
