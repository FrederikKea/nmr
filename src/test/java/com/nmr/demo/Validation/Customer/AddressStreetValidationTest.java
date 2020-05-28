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

import static org.junit.jupiter.api.Assertions.*;

public class AddressStreetValidationTest {

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
        testcustomer.setAddressStreetname("");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DigitsInStreetNameTest(){
        //test with digits in name
        testcustomer.setAddressStreetname("jacksonstreet 5");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest1(){
        testcustomer.setAddressStreetname("mågegade 5");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest2(){
        testcustomer.setAddressStreetname("Børge Alle 4");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest3(){
        testcustomer.setAddressStreetname("Æriksminde 45");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}
