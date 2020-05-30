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
    private static final Logger LOGGER = LoggerFactory.getLogger(DriversLicenseValidationTest.class);
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
        //test with normal letters
        testcustomer.setDriverslicense("bbbbbbb999");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void NumbersInZipcode(){
        //test with 255 numbers
        testcustomer.setDriverslicense("548013806029944318668395148882885576841166661161885936932589072630394365998765356315626207853420653757299623032170417567493634521922349679592672980854068540770789396641459482507746273663313819975017345082941621131284599572129914483918876491938954253297754");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertTrue(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

    @Test
    public void UpperBoundryInZipcode(){
        //test with 256 numbers
        testcustomer.setDriverslicense("5498013806029944318668395148882885576841166661161885936932589072630394365998765356315626207853420653757299623032170417567493634521922349679592672980854068540770789396641459482507746273663313819975017345082941621131284599572129914483918876491938954253297754");
        violations = validator.validate(testcustomer);
        LOGGER.info(testcustomer.toString());
        assertFalse(violations.isEmpty());
        LOGGER.info(violations.toString());
    }

}
