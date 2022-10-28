package PageObjectModel.Pages;

import Log.Log;
import Utilities.PageConstants.LoginPageConstants;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LoginPageConstants {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    Log log;

    /**
     * @method "typeEmail" is to send mail text to mail input.
     */
    public void typeEmail(){
        log = new Log();
        type(EmailInputTextLocator,"simgetestt@gmail.com");
        log.info("Mail is typed");
    }
    /**
     * @method "clickLogInButton" is to click LogIn Button.
     */
    public void clickLogInButton(){
        click(LogInButtonLocator);
    }
    /**
     * @method "typePassword" is to send password to password input.
     */
    public void typePassword(){
        type(PasswordInputTextLocator,"Testt123");
    }
    /**
     * @method "clickLoginButtonAfterPassword" is to click login button after password is typed.
     */
    public void clickLoginButtonAfterPassword(){
        log = new Log();
        click(LoginButtonAfterPasswordLocator);
        log.info("Password is typed and login button is clicked.");
    }

}
