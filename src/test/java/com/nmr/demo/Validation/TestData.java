package com.nmr.demo.Validation;

import com.nmr.demo.Model.Booking;
import com.nmr.demo.Model.Customer;

public class TestData {

    public Customer getTestCustomer(){
        return new Customer(
                0,                      // customer_id
                "jack",                  // firstName
                "daniels",               // lastName
                "jack street",     // addressStreetname
                "new jack city",        // addressCity
                8000,                // addressZipcode
                "country jack",      // addressCountry;
                "jack@jackson.com",         // email;
                "90909099",           // phonenumber;
                "2000-12-12",                // dob;
                "88888888"             // driverslicense;
        );
    }

    public Booking getTestBooking(){
        return new Booking(
            0,                                    //order_id;
            "Bent",                              //customers;
            "Pössl 2Win PLUS",                  //motorhome;
            "2050-12-12",                     //rentalStartTime
            "2051-12-12",                     //rentalStopTime
            "Citronvej 231",                //pickupStreetname
            "Holeby",                            //pickupCity;
            "4960",                           //pickupZipcode
            "Citronvej 231",               //dropoffStreetname
            "Holeby",                           //dropoffCity
            "4960",                          //dropoffZipcode
            "",                                     //extras
            ""                                    //comment
        );
    }

}
