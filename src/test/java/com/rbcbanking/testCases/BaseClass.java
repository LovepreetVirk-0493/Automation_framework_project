package com.rbcbanking.testCases;

import com.rbcbanking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.*;
import org.testng.annotations.Parameters;



public class BaseClass extends ReadConfig {
    public String baseURL = getwebURL();
    public String Username = getUserName();
    public String Password = getPassword();
    public static WebDriver driver;

    public static Logger logger;

    @Parameters("Browser")
    @BeforeClass
    public void setup(String br) {
        switch (br) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "Edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            case "Firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
        }
        driver.get(baseURL);

        logger = LogManager.getLogger("BaseClass");
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
