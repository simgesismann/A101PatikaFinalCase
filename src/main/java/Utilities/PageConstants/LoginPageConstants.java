package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageConstants extends BasePage {
    public LoginPageConstants(WebDriver driver) {
        super(driver);
    }
    public By EmailInputTextLocator = By.id("txtUserName");
    public By LogInButtonLocator = By.id("btnLogin");
    public By PasswordInputTextLocator = By.id("txtPassword");
    public By LoginButtonAfterPasswordLocator = By.name("btnEmailSelect");


}
