package com.nmr.demo.Validation;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Validation.Customer.EmailValidationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

//this is a test suite to test that the test data used in the other tests goes through without any violations
public class TestDataValidation {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailValidationTest.class);
    private Customer testcustomer = new Customer(
            0,                     // customer_id
            "jack",                  // firstName
            "daniels",                  // lastName
            "jack street",              // addressStreetname
            "new jack city",            // addressCity
            8000,                    // addressZipcode
            "country jack",             // addressCountry;
            "jack@jackson.com",         // email;
            "90909099",                 // phonenumber;
            "2000-12-12",                   // dob;
            "88888888"              // driverslicense;
    );

    @Before
    public void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @After
    public void close() {
        validatorFactory.close();
    }

    @Test
    public void isCustomerValid(){
        Set<ConstraintViolation<Customer>> violations = validator.validate(testcustomer);
        assertTrue(violations.isEmpty());
    }

}
