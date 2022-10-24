package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPagesConstants extends BasePage {
    public ProductPagesConstants(WebDriver driver) {
        super(driver);
    }
    public final By WeFoundNumbersOfProductLabelLocator = By.className("searchResultSummaryBar-CbyZhv5896ASVcYBLKmx");
    public final By ProductsLocator = By.className("productListContent-zAP0Y5msy8OHn5z7T_K_");

}
