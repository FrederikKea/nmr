package com.nmr.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

public class Booking {
    private int order_id;
    private String customers;
    private String motorhome;
    //skal vi have den ind i vores db eller hardcode valgmulighederne til denne?
    //private String season;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// needed for input field on html pages (in order to serve the right format)
    private String rentalStartTime;
    private String rentalStopTime;
    private String addressRentalStart;
    private String addressRentalStop;
    private String extras;
    private String comment;

    public Booking(int order_id, String customers, String motorhome, String rentalStartTime, String rentalStopTime, String addressRentalStart, String addressRentalStop, String extras, String comment) {
        this.order_id = order_id;
        this.customers = customers;
        this.motorhome = motorhome;
        this.rentalStartTime = rentalStartTime;
        this.rentalStopTime = rentalStopTime;
        this.addressRentalStart = addressRentalStart;
        this.addressRentalStop = addressRentalStop;
        this.extras = extras;
        this.comment = comment;
    }

    public Booking() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers = customers;
    }

    public String getMotorhome() {
        return motorhome;
    }

    public void setMotorhome(String motorhome) {
        this.motorhome = motorhome;
    }

    public String getRentalStartTime() {
        return rentalStartTime;
    }

    public void setRentalStartTime(String rentalStartTime) {
        this.rentalStartTime = rentalStartTime;
    }

    public String getRentalStopTime() {
        return rentalStopTime;
    }

    public void setRentalStopTime(String rentalStopTime) {
        this.rentalStopTime = rentalStopTime;
    }

    public String getAddressRentalStart() {
        return addressRentalStart;
    }

    public void setAddressRentalStart(String addressRentalStart) {
        this.addressRentalStart = addressRentalStart;
    }

    public String getAddressRentalStop() {
        return addressRentalStop;
    }

    public void setAddressRentalStop(String addressRentalStop) {
        this.addressRentalStop = addressRentalStop;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
