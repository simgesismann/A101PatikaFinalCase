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

    /**
     * "windowHandle" is to change window to operate other methods on it
     */
    public void windowHandle(){
        List<String> pages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pages.get(1));
    }

    /**
     * @method "assertProductDetailPageIsDirected" is to confirm that page is directed by finding element
     */
    public void assertProductDetailPageIsDirected(){
        Assertions.assertTrue(isDisplayed(ProductIdLocator),"Product detail page is not directed correctly");
    }
    /**
     * @returns "getTextOfProductName" returns product's name in detail page
     */
    public String getTextOfProductName(){
        return getText(ProductIdLocator);
    }

    /**
     * @method "rollAndClickAddToCartButton" is to scroll down to find element and click
     * @throws InterruptedException
     */
    public void rollAndClickAddToCartButton() throws InterruptedException {
        rollUntilFindElementAndClick(AddToCartButtonLocator);
        wait(10);
    }

    /**
     * @method "assertAddCartButtonIsClicked" is to confirm that button is clicked by finding element on pop-up
     * @throws InterruptedException
     */
    public void assertAddCartButtonIsClicked() throws InterruptedException {
        wait(10);
        Assertions.assertTrue(isDisplayed(ProductIsAddedToCartTitleLocator),"Product is not added to cart");
    }

    /**
     * @method "clickCloseButton" is to close pop-up
     */
    public void clickCloseButton(){
        click(CloseButtonLocator);
    }

    /**
     * @method "assertOtherBuyOptionsTitleIsDisplayed" is to confirm that product has other options of stores
     */
    public void assertOtherBuyOptionsTitleIsDisplayed(){
        rollUntilFindElement(OtherBuyOptionsTitleLocator);
        Assertions.assertTrue(isDisplayed(OtherBuyOptionsTitleLocator),"Other Buy Options Title is not displayed");
    }

    /**
     * @return "getTextOfProductName" returns product's name in detail page
     */
    public String getTextTitleOfOtherOptionsList(){
        List<WebElement> otherOptionsList = findAll(OtherBuyOptionsListLocator);
        WebElement otherOption = otherOptionsList.get(0);
        return otherOption.getText();
    }

    /**
     * "clickOtherOptionAddToCartButton" is to click AddToCartButton of other store
     * @throws InterruptedException
     */
    public void clickOtherOptionAddToCartButton() throws InterruptedException {
        click(AddToCartOtherBuyOptionButtonLocator);
        wait(10);
    }
}
