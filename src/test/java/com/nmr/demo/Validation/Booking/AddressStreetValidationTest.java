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

public class AddressStreetValidationTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressStreetValidationTest.class);
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
        testbooking.setPickupStreetname("");
        testbooking.setDropoffStreetname("");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DigitsInStreetNameTest(){
        //test with digits in name
        testbooking.setPickupStreetname("jacksonstreet 5");
        testbooking.setDropoffStreetname("jacksonstreet 5");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest1(){
        testbooking.setPickupStreetname("mågegade 5");
        testbooking.setDropoffStreetname("mågegade 5");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest2(){
        testbooking.setPickupStreetname("Børge Alle 4");
        testbooking.setDropoffStreetname("Børge Alle 4");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest3(){
        testbooking.setPickupStreetname("Æriksminde 45");
        testbooking.setDropoffStreetname("Æriksminde 45");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void EaccentLetterTest(){
        testbooking.setPickupStreetname("Vigers Allé");
        testbooking.setDropoffStreetname("Vigers Allé");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void ApostropheLetterTest(){
        testbooking.setPickupStreetname("Viger's Gade 5");
        testbooking.setDropoffStreetname("Viger's Gade 5");
        violations = validator.validate(testbooking);
        LOGGER.info(testbooking.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}
