package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageConstants extends BasePage {

    public HomePageConstants(WebDriver driver) {
        super(driver);
    }
    public By AcceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    public By MyCartButtonLocator = By.id("shoppingCart");
    public By LogInGenelButtonLocator = By.className("sf-OldMyAccount-sS_G2sunmDtZl9Tld5PR user-info");
    public By CreateUserButtonLocator = By.id("register");
}
