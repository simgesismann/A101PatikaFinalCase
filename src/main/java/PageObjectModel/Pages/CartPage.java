package PageObjectModel.Pages;

import PageObjectModel.BasePage;
import Utilities.PageConstants.CartPageConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

public class CartPage extends CartPageConstants {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void assertCartPageIsDirected(){
        Assertions.assertTrue(isDisplayed(BasketHeaderTitleLocator),"Basket page is not directed");
    }
    public void getTextOfOtherFirmTitleInCartPage(){
        otherFirmTitleInCartPage = getText(OtherFirmTitleInCartPageLocator);
    }
    public void assertAddedProductFirmIsCorrectInCart(){
        Assertions.assertEquals(otherFirmTitleInCartPage,otherFirmTitle);
    }
}
