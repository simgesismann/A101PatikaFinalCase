package PageObjectModel.Pages;

import Log.Log;
import Utilities.PageConstants.ProductPagesConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends ProductPagesConstants {
    Log log;
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @method "assertProductPageIsDirected" is confirm that page is directed by finding element.
     */
    public void assertProductPageIsDirected(){
        log = new Log();
        Assertions.assertTrue(isDisplayed(WeFoundNumbersOfProductLabelLocator),"Products page is not directed");
        log.info("Product page is directed.");
    }

    /**
     * @method "chooseOneProduct" is a method to choose a product from list of search
     * @throws InterruptedException
     */
    public void chooseOneProduct() throws InterruptedException {
        click(ProductsLocator);
        wait(5);
        log.info("One of products is chosen.");
    }
}
