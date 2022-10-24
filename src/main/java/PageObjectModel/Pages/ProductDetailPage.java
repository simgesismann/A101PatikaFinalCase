package PageObjectModel.Pages;

import Utilities.PageConstants.ProductDetailPageConstants;
import Utilities.PageConstants.ProductPagesConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailPage extends ProductDetailPageConstants {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void windowHandle(){
        List<String> pages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pages.get(1));
    }
    public void assertProductDetailPageIsDirected(){
        Assertions.assertTrue(isDisplayed(ProductIdLocator),"Product detail page is not directed correctly");
    }
    public void rollAndClickAddToCartButton() throws InterruptedException {
        rollUntilFindElementAndClick(AddToCartButtonLocator);
        wait(10);
    }
    public void assertAddCartButtonIsClicked() throws InterruptedException {
        wait(5);
        Assertions.assertTrue(isDisplayed(ProductIsAddedToCartTitleLocator),"Product is not added to cart");
    }
    public void clickCloseButton(){
        click(CloseButtonLocator);
    }
    public void assertOtherBuyOptionsTitleIsDisplayed(){
        rollUntilFindElement(OtherBuyOptionsTitleLocator);
        Assertions.assertTrue(isDisplayed(OtherBuyOptionsTitleLocator),"Other Buy Options Title is not displayed");
    }
    public void getTextTitleOfOtherOptionsList(){
        List<WebElement> otherOptionsList = findAll(OtherBuyOptionsListLocator);
        WebElement otherOption = otherOptionsList.get(0);
        otherFirmTitle = otherOption.getText();
    }
    public void clickOtherOptionAddToCartButton() throws InterruptedException {
        click(AddToCartOtherBuyOptionButtonLocator);
        wait(10);
    }

}
