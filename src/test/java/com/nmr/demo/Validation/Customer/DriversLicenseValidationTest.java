package com.nmr.demo.Validation.Customer;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Validation.TestData;
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DriversLicenseValidationTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailValidationTest.class);
    private Customer testcustomer;
    Set<ConstraintViolation<Customer>> violations;

    @Before
    public void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        TestData t = new TestData();
        testcustomer = t.getTestCustomer();
    }

    @After
    public void close() {
        validatorFactory.close();
    }

    @Test
    public void BlankTest(){
        //test with blank (Null is being taken care of by framework)
        testcustomer.setDriverslicense("");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void LettersInZipcode(){
        //test with 256 chars
        testcustomer.setDriverslicense("OMRUYrwEqmCqBUryR4e4AcReKEf3b2NUCbiwEtyRoYPsxcyH6RdgYyGZIW00BY9UcXtuc8IzBn5q7n5bcd31V4iPNuSMfPXKQHdL1ndD74rD6t34MIjqvNn3hnSsQqTgVRgba0RUwD08QRBqPm2lc4LWfEOr4ruVG9hSpCJNC9Pqr0Zq6tWnnaIlChQku8F8CtC4ialNMzpC8M9oRVe5v6lHLvehTIIMUt6ytYR1DDEnV31kMWipL1uT1zxStV5f");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}
