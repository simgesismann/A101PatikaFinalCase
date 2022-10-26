package PageObjectModel.Pages;
import Utilities.PageConstants.CartPageConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends CartPageConstants {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void assertCartPageIsDirected(){
        Assertions.assertTrue(isDisplayed(BasketHeaderTitleLocator),"Basket page is not directed");
    }
    public String getTextOfProductNameInCartPage(){
        return getText(ProductNameInCartPageLocator);
    }
    public void assertAddedProductsAreSame(){
        List<WebElement> nameList = findAll(ProductNameInCartPageLocator);
        String firstProductName = nameList.get(0).getText();
        String secondProductName = nameList.get(1).getText();
        Assertions.assertTrue(firstProductName.contains(secondProductName));
    }
    public String getTextOfOtherFirmTitleInCartPage(){
        return getText(OtherFirmTitleInCartPageLocator);
    }
}
