package com.nmr.demo.Validation;

import com.nmr.demo.Model.Booking;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDataValidation.class);
    private Customer testcustomer;
    private Booking testbooking;
    Set<ConstraintViolation<Customer>> Customerviolations;
    Set<ConstraintViolation<Booking>> Bookingviolations;

    @Before
    public void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        TestData t = new TestData();
        testcustomer = t.getTestCustomer();
        testbooking = t.getTestBooking();
    }

    @After
    public void close() {
        validatorFactory.close();
    }

    @Test
    public void isCustomerValid(){
        Customerviolations = validator.validate(testcustomer);
        assertTrue(Customerviolations.isEmpty());
    }

    @Test
    public void isBookingValid(){
        Bookingviolations = validator.validate(testbooking);
        assertTrue(Bookingviolations.isEmpty());
    }

}
