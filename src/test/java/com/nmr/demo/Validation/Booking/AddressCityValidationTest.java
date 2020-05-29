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

public class AddressCityValidationTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressCityValidationTest.class);
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
    public void BlankTest(){
        //test with blank (Null is being taken care of by framework)
        testbooking.setPickupCity("");
        testbooking.setDropoffCity("");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DigitsInCityNameTest(){
        //test with digits in name
        testbooking.setPickupCity("Brocity 6");
        testbooking.setDropoffCity("Brocity 6");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest1(){
        //test with special letter
        testbooking.setPickupCity("Århus");
        testbooking.setDropoffCity("Århus");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest2(){
        //test with special letter
        testbooking.setPickupCity("Brønderslev");
        testbooking.setDropoffCity("Brønderslev");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest3(){
        //test with special letter
        testbooking.setPickupCity("Brænderup");
        testbooking.setDropoffCity("Brænderup");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }
}
