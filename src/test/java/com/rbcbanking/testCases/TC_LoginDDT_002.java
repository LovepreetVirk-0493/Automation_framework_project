package com.rbcbanking.testCases;
import com.rbcbanking.pageObjects.LoginPage;
import com.rbcbanking.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass
{
    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pass)
    {
        LoginPage lp = new LoginPage(driver);
        lp.enterUserName(user);
        logger.info("Username is provided");

        lp.enterUserPassword(pass);
        logger.info("Password is provided");
        lp.clickLogin();
        if(isAlertPresent())
        {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.fail();
            logger.warn("Wrong username or password");
        }
        else {
            Assert.assertTrue(true);
            lp.clickLogOut();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            logger.info("Login successful");
        }
    }

    public boolean isAlertPresent()
    {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DataProvider(name = "LoginData")
    public String [][] getData() throws IOException {
        String path = "G:/Code_WIth_harry/Automation_framework/src/test/java/com/rbcbanking/testData/LoginDetails.xlsx";

        int rownum = XLUtils.getRowCount(path,"Table1");
        int colcount = XLUtils.getCellCount(path,"Table1",1);

        String loginData [][] = new String[rownum][colcount];
        for (int i =1; i<=rownum;i++)
        {
            for(int j =0;j<colcount;j++){
                loginData[i-1][j] = XLUtils.getCellData(path,"Table1",i,j);
            }
        }
        return loginData;
    }

}
