package PageObjectModel.Pages;

import Utilities.PageConstants.LogInPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends LogInPageConstants {

    public LogInPage(WebDriver driver) {
        super(driver);
    }
    public void typeEmail(){
        //type(EmailInputTextLocator,"simgesismann@gmail.com");
    }

}
