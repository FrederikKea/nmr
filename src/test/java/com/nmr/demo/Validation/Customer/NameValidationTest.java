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

public class NameValidationTest {

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
        testcustomer.setFirstName("");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DigitsInNameTest(){
        //test with digits in name
        testcustomer.setFirstName("jackson1");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest1(){
        //test with underscore
        testcustomer.setFirstName("Åge");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest2(){
        //test with underscore
        testcustomer.setFirstName("Børge");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void DanishLetterTest3(){
        //test with underscore
        testcustomer.setFirstName("Ærik");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}
