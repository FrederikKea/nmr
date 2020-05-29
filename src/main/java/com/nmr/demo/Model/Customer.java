package com.nmr.demo.Model;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Customer {

    private int customer_id;
    @Pattern(regexp="^[ÆØÅæøåa-zA-Z]{2,255}",message="vælg et navn mellem 2-255 bogstaver")
    private String firstName;
    @Pattern(regexp="^[ÆØÅæøåa-zA-Z]{2,255}",message="vælg et navn mellem 2-255 bogstaver")
    private String lastName;
    @Pattern(regexp="^[ é'ÆØÅæøåa-zA-Z0-9]{2,255}",message="vælg et gadenavn mellem 2-255 bogstaver")
    private String addressStreetname;
    @Pattern(regexp="^[ ÆØÅæøåa-zA-Z]{2,255}",message="vælg et bynavn mellem 2-255 bogstaver")
    private String addressCity;
    @Range(min=1, max=2147483646, message="vælg et gyldigt postnummer" )
    private int addressZipcode;
    @Pattern(regexp="^[ ÆØÅæøåa-zA-Z]{2,255}",message="vælg et landenavn mellem 2-255 bogstaver")
    private String addressCountry;
    @NotBlank(message="vælg en gyldig email")
    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z0-9_]+\\.\\w+", message="vælg en gyldig email")
    private String email;
    @Pattern(regexp="^[0-9]{6,255}",message="vælg et telefonnummer mellem 6-255 karakterer")
    private String phonenumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// needed for input field on html pages (in order to serve the right format)
    private String dob;
    @Pattern(regexp="^[0-9]{1,255}",message="vælg et kørekortnummer mellem 1-255 karakterer")
    private String driverslicense;



    public Customer(int customer_id, @Pattern(regexp = "^[ÆØÅæøåa-zA-Z]{2,255}", message = "vælg et navn mellem 2-255 bogstaver") String firstName, @Pattern(regexp = "^[ÆØÅæøåa-zA-Z]{2,255}", message = "vælg et navn mellem 2-255 bogstaver") String lastName, @Pattern(regexp = "^[ ÆØÅæøåa-zA-Z0-9]{2,255}", message = "vælg et gadenavn mellem 2-255 bogstaver") String addressStreetname, @Pattern(regexp = "^[ ÆØÅæøåa-zA-Z]{2,255}", message = "vælg et bynavn mellem 2-255 bogstaver") String addressCity, @Range(min = 1, max = 2147483647, message = "vælg et gyldigt postnummer") int addressZipcode, @Pattern(regexp = "^[ ÆØÅæøåa-zA-Z]{2,255}", message = "vælg et landenavn mellem 2-255 bogstaver") String addressCountry, @NotBlank(message = "vælg en gyldig email") @Email(message = "vælg en gyldig email") String email, @Pattern(regexp = "^[0-9]{6,255}", message = "vælg et telefonnummer mellem 6-255 karakterer") String phonenumber, String dob, @Pattern(regexp = "^[0-9]{1,255}", message = "vælg et kørekortnummer mellem 1-255 karakterer") String driverslicense) {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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
