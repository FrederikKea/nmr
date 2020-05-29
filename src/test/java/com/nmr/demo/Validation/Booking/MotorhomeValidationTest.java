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

public class MotorhomeValidationTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(MotorhomeValidationTest.class);
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
        //test with empty string
        testbooking.setMotorhome("");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}
