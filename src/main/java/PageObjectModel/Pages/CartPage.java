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
    public void getTextOfProductNameInCartPage(){
        productNameInCartPage = getText(ProductNameInCartPageLocator);
    }
    public void printProductNameInDetailPageAndCartPage(){
        System.out.println("in cart page: "+productNameInCartPage );
        System.out.println("in detail page :"+productNameInDetailPage);
    }
    public void getTextOfOtherFirmTitleInCartPage(){
        otherFirmTitleInCartPage = getText(OtherFirmTitleInCartPageLocator);
    }
    public void assertAddedProductFirmIsCorrectInCart(){
        Assertions.assertEquals(otherFirmTitleInCartPage,otherFirmTitle);
    }
}
