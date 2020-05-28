package com.nmr.demo.Validation;

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


}
