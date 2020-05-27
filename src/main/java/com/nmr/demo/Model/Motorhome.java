package com.nmr.demo.Model;

public class Motorhome {
    private String modelName;
    private int modelPrize;

    public Motorhome(String modelName, int modelPrize) {
        this.modelName = modelName;
        this.modelPrize = modelPrize;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelPrize() {
        return modelPrize;
    }

    public void setModelPrize(int modelPrize) {
        this.modelPrize = modelPrize;
    }
}
