package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageConstants extends BasePage {

    public HomePageConstants(WebDriver driver) {
        super(driver);
    }
    public By AcceptCookiesLocator = By.id("onetrust-accept-btn-handler");
}