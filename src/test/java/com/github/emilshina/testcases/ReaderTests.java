package com.github.emilshina.testcases;

import com.github.emilshina.model.User;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for verification of Menu options.
 */
@Slf4j
public class ReaderTests extends BaseClass {

    @AfterMethod
    public void afterEachMethod() {
        log.info("After method of ReaderTests class.");
    }

    @BeforeMethod
    public void beforeEachMethod() {
        log.info("Before method of ReaderTests class.");
    }

    @Data(source = "data-array.json", entity = User[].class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    public void userCanBeReadFromJsonArrayWithArrayClass(final User user) {
        log.info("User from json array (Array class) {}.", user.getUserName());
    }

    @Data(source = "data-array.json", entity = User.class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    public void userCanBeReadFromJsonArrayWithObjectClass(final User user) {
        log.info("User from json array (Object class) {}.", user.getUserName());
    }

    @Data(source = "data-single-object.json", entity = User.class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    public void userCanBeReadFromJsonObjectWithObjectClass(final User user) {
        log.info("User from json object (Object class) {}.", user.getUserName());
    }

    @Data(source = "data-single-object.json", entity = User[].class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    public void userCanBeReadFromJsonObjectWithArrayClass(final User user) {
        log.info("User from json object (Array class) {}.", user.getUserName());
    }

    @Data(source = "data.csv", entity = User.class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    public void userCanBeReadFromCsvFileWithObjectClass(final User user) {
        log.info("User from csv file (Object class) {}.", user.getUserName());
    }
}
