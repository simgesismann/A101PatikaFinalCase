package PageObjectModel.Pages;

import Utilities.PageConstants.LoginPageConstants;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LoginPageConstants {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void typeEmail(){
        type(EmailInputTextLocator,"simgetestt@gmail.com");
    }
    public void clickLogInButton(){
        click(LogInButtonLocator);
    }
    public void typePassword(){
        type(PasswordInputTextLocator,"Testt123");
    }
    public void clickLoginButtonAfterPassword(){
        click(LoginButtonAfterPasswordLocator);
    }

}
