package com.rbcbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "uid")
    @CacheLookup
    WebElement UserId;
    @FindBy(name = "password")
    @CacheLookup
    WebElement Password;
    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement LoginButton;
    @FindBy(xpath ="//a[normalize-space()='Log out']")
    @CacheLookup
    WebElement LogOutBtn;

public void enterUserName(String username){
    UserId.sendKeys(username);
}
    public void enterUserPassword(String Upassword){
        Password.sendKeys(Upassword);
    }
    public void clickLogin(){
        LoginButton.click();
    }
    public void clickLogOut()
    {
        LogOutBtn.click();
    }


}

