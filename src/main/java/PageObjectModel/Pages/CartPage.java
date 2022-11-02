package PageObjectModel.Pages;
import Log.Log;
import Utilities.PageConstants.CartPageConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends CartPageConstants {
    Log log=new Log();
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @method "assertCartPageIsDirected" is to confirm CartPage is directed.
     */
    public void assertCartPageIsDirected(){
        Assertions.assertTrue(isDisplayed(CartHeaderTitleLocator),"Cart page is not directed");
        log.info("Cart Page is directed.");
    }
    /**
     * @returns "getTextOfProductNameInCartPage" returns product name in cart page.
     */
    public String getTextOfProductNameInCartPage(){
        return getText(ProductNameInCartPageLocator);
    }
    /**
     * @method "assertAddedProductsAreSame" is to confirm that first two products in cart page has same names.
     */
    public void assertAddedProductsAreSame(){
        List<WebElement> nameList = findAll(ProductNameInCartPageLocator);
        String firstProductName = nameList.get(0).getText();
        String secondProductName = nameList.get(1).getText();
        Assertions.assertTrue(firstProductName.contains(secondProductName));
        log.info("In cart page, added products are same.");
    }
    /**
     * @returns "getTextOfOtherFirmTitleInCartPage" returns firm title of product in cart page.
     */
    public String getTextOfOtherFirmTitleInCartPage(){
        return getText(OtherFirmTitleInCartPageLocator);
    }
}
