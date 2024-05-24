package com.rbcbanking.testCases;

import com.rbcbanking.pageObjects.AddCustomerPage;
import com.rbcbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.Random;

public class TC_addCustomerTest_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.enterUserName(Username);
        lp.enterUserPassword(Password);
        lp.clickLogin();

        Thread.sleep(2000);

        AddCustomerPage addCus = new AddCustomerPage(driver);
        Thread.sleep(2000);
        addCus.clickAddCustomerlink();
        Thread.sleep(10000);

        addCus.enterUserName("Lovepreet");
        addCus.chooseGender("female");
        addCus.setDateOfBirthOption("2001220215");
        Thread.sleep(1500);
        addCus.enterAddress("canada");
        addCus.enterCity("Calgary");
        addCus.enterState("alberta");
        addCus.enterPin("T3j2j4");
        addCus.enterMobile("2222222222");
        addCus.enterEmail(randomString()+"@gmail.com");
        addCus.enterPassword("LoveIsWar");
        Thread.sleep(1500);
        addCus.clickSubmit();
        Thread.sleep(3000);

    }

    public String randomString()
    {
        return RandomStringUtils.randomAlphabetic(10);
    }


}
