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

public class CommentValidationTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentValidationTest.class);
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
        testbooking.setComment("");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void WithinBoundryTest(){
        //test with 255 character string
        testbooking.setComment("AdMadl6HAmf93zDNS2H8zAJdmGHElz65O1psfZOa3hSZshsqhof9LKZVDXJ1oqdL8d3x3m1PPh0uU9Rajpo1A4A5ECZdSBXqunh0dgvDPU5MKIgFYwonIf4lf9NpquPP1TbODo3URppjM5oiH8ONY5FGpaJfN0W3WB7KAk0yfsq1EI4wimuW3GDxKoNo6AsCpRI6kprcYoZ95yz9V59H3roDKDfYSlLKgOVvD9mJTtziqiEDCdzTCeeUJ2xsldX");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void UpperBoundryTest(){
        //test with 256 character string
        testbooking.setComment("AdMadl6HAmf93nzDNS2H8zAJdmGHElz65O1psfZOa3hSZshsqhof9LKZVDXJ1oqdL8d3x3m1PPh0uU9Rajpo1A4A5ECZdSBXqunh0dgvDPU5MKIgFYwonIf4lf9NpquPP1TbODo3URppjM5oiH8ONY5FGpaJfN0W3WB7KAk0yfsq1EI4wimuW3GDxKoNo6AsCpRI6kprcYoZ95yz9V59H3roDKDfYSlLKgOVvD9mJTtziqiEDCdzTCeeUJ2xsldX");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}