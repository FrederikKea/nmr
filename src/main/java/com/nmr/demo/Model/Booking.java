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
    private String pickupStreetname;
    private String pickupCity;
    private String pickupZipcode;
    private String dropoffStreetname;
    private String dropoffCity;
    private String dropoffZipcode;
    private String extras;
    private String comment;

    public Booking(int order_id, String customers, String motorhome, String rentalStartTime, String rentalStopTime, String pickupStreetname, String pickupCity, String pickupZipcode, String dropoffStreetname, String dropoffCity, String dropoffZipcode, String extras, String comment) {
        this.order_id = order_id;
        this.customers = customers;
        this.motorhome = motorhome;
        this.rentalStartTime = rentalStartTime;
        this.rentalStopTime = rentalStopTime;
        this.pickupStreetname = pickupStreetname;
        this.pickupCity = pickupCity;
        this.pickupZipcode = pickupZipcode;
        this.dropoffStreetname = dropoffStreetname;
        this.dropoffCity = dropoffCity;
        this.dropoffZipcode = dropoffZipcode;
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

    public String getPickupStreetname() {
        return pickupStreetname;
    }

    public void setPickupStreetname(String pickupStreetname) {
        this.pickupStreetname = pickupStreetname;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getPickupZipcode() {
        return pickupZipcode;
    }

    public void setPickupZipcode(String pickupZipcode) {
        this.pickupZipcode = pickupZipcode;
    }

    public String getDropoffStreetname() {
        return dropoffStreetname;
    }

    public void setDropoffStreetname(String dropoffStreetname) {
        this.dropoffStreetname = dropoffStreetname;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    public void setDropoffCity(String dropoffCity) {
        this.dropoffCity = dropoffCity;
    }

    public String getDropoffZipcode() {
        return dropoffZipcode;
    }

    public void setDropoffZipcode(String dropoffZipcode) {
        this.dropoffZipcode = dropoffZipcode;
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


    @Override
    public String toString() {
        return "Booking{" +
                "order_id=" + order_id +
                ", customers='" + customers + '\'' +
                ", motorhome='" + motorhome + '\'' +
                ", rentalStartTime='" + rentalStartTime + '\'' +
                ", rentalStopTime='" + rentalStopTime + '\'' +
                ", pickupStreetname='" + pickupStreetname + '\'' +
                ", pickupCity='" + pickupCity + '\'' +
                ", pickupZipcode='" + pickupZipcode + '\'' +
                ", dropoffStreetname='" + dropoffStreetname + '\'' +
                ", dropoffCity='" + dropoffCity + '\'' +
                ", dropoffZipcode='" + dropoffZipcode + '\'' +
                ", extras='" + extras + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
