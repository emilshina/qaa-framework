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
public class MenuTests extends BaseClass {

    @BeforeMethod
    public void beforeEachMethod() {
        log.info("Before method of Menu class.");
    }

    @AfterMethod
    public void afterEachMethod() {
        log.info("After method of Menu class.");
    }

    @Data(source = "data.json", entity = User[].class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    public void userCanOpenContactsPage(final User user) {
        log.info("Contacts page was opened by user {}.", user.getUserName());
    }

    @Data(source = "data.csv", entity = User.class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    public void userCanOpenAboutPage(final User user) {
        log.info("About page was opened by user {}", user.getUserName());
    }
}
