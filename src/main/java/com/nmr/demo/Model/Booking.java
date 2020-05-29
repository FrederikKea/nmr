package com.nmr.demo.Model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Booking {
    private int order_id;
    @Pattern(regexp="^[ ÆØÅæøåa-zA-Z]{2,255}",message="vælg en kunde")
    private String customers;
    @NotBlank (message="vælg et motorhome")
    private String motorhome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// needed for input field on html pages (in order to serve the right format)
    private String rentalStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// needed for input field on html pages (in order to serve the right format)
    private String rentalStopTime;
    @Pattern(regexp="^[ é'ÆØÅæøåa-zA-Z0-9]{2,255}",message="vælg et gadenavn mellem 2-255 bogstaver")
    private String pickupStreetname;
    @Pattern(regexp="^[ ÆØÅæøåa-zA-Z]{2,255}",message="vælg et bynavn mellem 2-255 bogstaver")
    private String pickupCity;
    //danish zip codes only
    @Range(min=1000, max=9999, message="vælg et gyldigt dansk postnummer" )
    private String pickupZipcode;
    @Pattern(regexp="^[ é'ÆØÅæøåa-zA-Z0-9]{2,255}",message="vælg et gadenavn mellem 2-255 bogstaver")
    private String dropoffStreetname;
    @Pattern(regexp="^[ ÆØÅæøåa-zA-Z]{2,255}",message="vælg et bynavn mellem 2-255 bogstaver")
    private String dropoffCity;
    @Range(min=1000, max=9999, message="vælg et gyldigt dansk postnummer" )
    private String dropoffZipcode;
    private String extras;
    @Length(min=0, max=255)
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
}
