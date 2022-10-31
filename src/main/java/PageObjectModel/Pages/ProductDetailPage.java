package PageObjectModel.Pages;

import Log.Log;
import Utilities.PageConstants.ProductDetailPageConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailPage extends ProductDetailPageConstants {
    Log log;
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * "windowHandle" is to change window to operate other methods on it
     */
    public void windowHandle(){
        log = new Log();
        List<String> pages = new ArrayList<>(driver.getWindowHandles());
        int pageCount = pages.size();
        driver.switchTo().window(pages.get(pageCount-1));
        log.info("Window is handled.");
    }
    /**
     * @method "assertProductDetailPageIsDirected" is to confirm that page is directed by finding element
     */
    public void assertProductDetailPageIsDirected(){
        log = new Log();
        Assertions.assertTrue(isDisplayed(ProductIdLocator),"Product detail page is not directed correctly");
        log.info("Product detail page is directed.");
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
        log = new Log();
        wait(10);
        rollUntilFindElementAndClick(AddToCartButtonLocator);
        wait(10);
        log.info("Scrolled down to click AddToCart Button");
    }

    /**
     * @method "assertAddCartButtonIsClicked" is to confirm that button is clicked by finding element on pop-up
     * @throws InterruptedException
     */
    public void assertAddCartButtonIsClicked() throws InterruptedException {
        log = new Log();
        wait(10);
        Assertions.assertTrue(isDisplayed(ProductIsAddedToCartTitleLocator),"Product is not added to cart");
        log.info("AddToCart Button is clicked");
    }

    /**
     * @method "clickCloseButton" is to close pop-up
     */
    public void clickCloseButton(){
        log = new Log();
        click(CloseButtonLocator);
        log.info("Pop-up is closed");
    }

    /**
     * @method "assertOtherBuyOptionsTitleIsDisplayed" is to confirm that product has other options of stores
     */
    public void assertOtherBuyOptionsTitleIsDisplayed(){
        log = new Log();
        rollUntilFindElement(OtherBuyOptionsTitleLocator);
        Assertions.assertTrue(isDisplayed(OtherBuyOptionsTitleLocator),"Other Buy Options Title is not displayed");
        log.info("Other stores options are displayed.");
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
        log = new Log();
        click(AddToCartOtherBuyOptionButtonLocator);
        wait(10);
        log.info("Other store's AddToCart Button is clicked.");
    }
}
