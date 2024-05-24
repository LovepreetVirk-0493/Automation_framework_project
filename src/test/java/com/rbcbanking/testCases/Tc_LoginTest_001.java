package com.rbcbanking.testCases;

import com.rbcbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest() {
        driver.get(baseURL);
        logger.info("The Url to the website is opened");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserName(Username);
        logger.info("Username is entered");

        loginPage.enterUserPassword(Password);
        logger.info("Password is entered");

        loginPage.clickLogin();
        logger.info("Login button is clicked");

        if ( driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login test is passed");
        }
        else{
            Assert.assertTrue(false);
            logger.info("Login test is failed");
        }
    }
}
