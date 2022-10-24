package PageObjectModel.Pages;

import Utilities.PageConstants.ProductPagesConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends ProductPagesConstants {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void assertProductPageIsDirected(){
        Assertions.assertTrue(isDisplayed(WeFoundNumbersOfProductLabelLocator),"Products page is not directed");
    }
    public void chooseOneProduct() throws InterruptedException {
        List<WebElement> productsList = findAll(ProductsLocator);
        WebElement firstProduct = productsList.get(0);
        firstProduct.click();
        wait(5);
    }
}
