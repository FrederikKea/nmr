package com.nmr.demo.Validation.Booking;

import com.nmr.demo.Model.Booking;
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

public class ZipcodeValidationTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(ZipcodeValidationTest.class);
    private Booking testbooking;
    Set<ConstraintViolation<Booking>> violations;

    @Before
    public void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        TestData t = new TestData();
        testbooking = t.getTestBooking();
    }

    @After
    public void close() {
        validatorFactory.close();
    }

    @Test
    public void NegativeBoundryTest(){
        //test with negative
        testbooking.setPickupZipcode("-1");
        testbooking.setDropoffZipcode("-1");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void ZeroBoundryTest(){
        //test with zero
        testbooking.setPickupZipcode("0");
        testbooking.setDropoffZipcode("0");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void WithinBoundryTest(){
        //test with acceptable number even though our testdata is acceptable
        testbooking.setPickupZipcode("9999");
        testbooking.setDropoffZipcode("9999");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void UpperBoundryTest(){
        //test with high number
        testbooking.setPickupZipcode("10000");
        testbooking.setDropoffZipcode("10000");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}
