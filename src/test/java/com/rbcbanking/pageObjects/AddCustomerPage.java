package com.rbcbanking.pageObjects;

import com.rbcbanking.testCases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends BaseClass {

    WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement addCustomerBtn;

    @FindBy(how = How.NAME, using= "name")
    @CacheLookup
    WebElement nameBox;

    @FindBy(how = How.NAME, using= "rad1")
    @CacheLookup
    WebElement genderOption;

    @FindBy(how = How.ID_OR_NAME, using= "dob")
    @CacheLookup
    WebElement dateOfBirthOption;

    @FindBy(how = How.ID_OR_NAME, using= "addr")
    @CacheLookup
    WebElement addressBox;

    @FindBy(how = How.ID_OR_NAME, using= "city")
    @CacheLookup
    WebElement cityBox;

    @FindBy(how = How.ID_OR_NAME, using= "state")
    @CacheLookup
    WebElement stateBox;

    @FindBy(how = How.ID_OR_NAME, using= "pinno")
    @CacheLookup
    WebElement pinNo;

    @FindBy(how = How.ID_OR_NAME, using= "telephoneno")
    @CacheLookup
    WebElement telephoneBox;

    @FindBy(how = How.ID_OR_NAME, using= "emailid")
    @CacheLookup
    WebElement emailBox;

    @FindBy(how = How.ID_OR_NAME, using= "password")
    @CacheLookup
    WebElement passwordBox;

    @FindBy(how = How.ID_OR_NAME, using= "sub")
    @CacheLookup
    WebElement submitBtn;


    public void clickAddCustomerlink()
    {
        addCustomerBtn.click();
    }

    public void enterUserName(String Username)
    {
        nameBox.sendKeys(Username);
    }

    public void chooseGender( String gender)
    {
        genderOption.click();
    }

    public void setDateOfBirthOption(String yyyy)
    {
        dateOfBirthOption.sendKeys(yyyy);
    }

    public void enterAddress(String address)
    {
        addressBox.sendKeys(address);
    }

    public void enterCity(String city)
    {
        cityBox.sendKeys(city);
    }

    public void enterState(String state)
    {
        stateBox.sendKeys(state);
    }

    public void enterPin(String Pin)
    {
        pinNo.sendKeys(Pin);
    }

    public void enterMobile(String no)
    {
        telephoneBox.sendKeys(no);
    }

    public void enterEmail (String email)
    {
        emailBox.sendKeys(email);
    }

    public void enterPassword(String pass)
    {
        passwordBox.sendKeys(pass);
    }

    public void clickSubmit()
    {
        submitBtn.click();
    }
}
