package PageObjectModel.Pages;
import Utilities.PageConstants.CartPageConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
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
    public String getTextOfOtherFirmTitleInCartPage(){
        return getText(OtherFirmTitleInCartPageLocator);
    }
}
