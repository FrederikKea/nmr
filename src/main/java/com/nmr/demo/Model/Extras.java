package com.nmr.demo.Model;

public class Extras {
    private int extras_id;
    private String description;
    private double extrasPrice;

    public Extras(int extras_id, String description, double extrasPrice) {
        this.extras_id = extras_id;
        this.description = description;
        this.extrasPrice = extrasPrice;
    }

    public Extras() {
    }

    public int getExtras_id() {
        return extras_id;
    }

    public void setExtras_id(int extras_id) {
        this.extras_id = extras_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getExtrasPrice() {
        return extrasPrice;
    }

    public void setExtrasPrice(double extrasPrice) {
        this.extrasPrice = extrasPrice;
    }
}
