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
    public By LogInGenelButtonLocator = By.className("sf-OldMyAccount-d0xCHLV38UCH5cD9mOXq");
    public By LogInButtonLocator = By.id("login");
    public By SelectLocationButtonLocator = By.className("shipping-src-universal-partials-ShippingLocation-components-locationSelector-button-ShippingLocationSelectorButton__locationLabel");

}
