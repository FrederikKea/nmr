package com.nmr.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Customer {
    /*
    private int customer_id;
    private String firstName;
    private String lastName;
    private int addressStreetname;
    private int email;
    private int phonenumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// needed for input field on html pages (in order to serve the right format)
    private Date dob;
    private String driverslicense;

    public Customer() {
    }

    public Customer(int customer_id, String firstName, String lastName, int addressStreetname, int email, int phonenumber, Date dob, String driverslicense) {
        this.customer_id = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressStreetname = addressStreetname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.dob = dob;
        this.driverslicense = driverslicense;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAddressStreetname() {
        return addressStreetname;
    }

    public void setAddressStreetname(int addressStreetname) {
        this.addressStreetname = addressStreetname;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDriverslicense() {
        return driverslicense;
    }

    public void setDriverslicense(String driverslicense) {
        this.driverslicense = driverslicense;
    }
*/

    private int customer_id;
    private String firstName;
    private String lastName;
    private String addressStreetname;
    private String addressCity;
    private int addressZipcode;
    private String addressCountry;
    private String email;
    private String phonenumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// needed for input field on html pages (in order to serve the right format)
    private Date dob;
    private String driverslicense;

    public Customer(int customer_id, String firstName, String lastName, String addressStreetname, String addressCity, int addressZipcode, String addressCountry, String email, String phonenumber, Date dob, String driverslicense) {
        this.customer_id = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressStreetname = addressStreetname;
        this.addressCity = addressCity;
        this.addressZipcode = addressZipcode;
        this.addressCountry = addressCountry;
        this.email = email;
        this.phonenumber = phonenumber;
        this.dob = dob;
        this.driverslicense = driverslicense;
    }

    public Customer() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressStreetname() {
        return addressStreetname;
    }

    public void setAddressStreetname(String addressStreetname) {
        this.addressStreetname = addressStreetname;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public int getAddressZipcode() {
        return addressZipcode;
    }

    public void setAddressZipcode(int addressZipcode) {
        this.addressZipcode = addressZipcode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDriverslicense() {
        return driverslicense;
    }

    public void setDriverslicense(String driverslicense) {
        this.driverslicense = driverslicense;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressStreetname='" + addressStreetname + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressZipcode='" + addressZipcode + '\'' +
                ", addressCountry='" + addressCountry + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", dob='" + dob + '\'' +
                ", driverslicense='" + driverslicense + '\'' +
                '}';
    }

    /*
    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressStreetname='" + addressStreetname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", dob='" + dob + '\'' +
                ", driverslicense='" + driverslicense + '\'' +
                '}';
    }
    */
}
