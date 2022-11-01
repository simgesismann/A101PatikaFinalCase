package Utilities.PageConstants;

import Log.Log;
import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPagesConstants extends BasePage {
    Log log = new Log();
    public ProductPagesConstants(WebDriver driver) {
        super(driver);
    }
    public final By WeFoundNumbersOfProductLabelLocator = By.className("searchResultSummaryBar-CbyZhv5896ASVcYBLKmx");
    public final By ProductsLocator = By.xpath("//h3[@data-test-id='product-card-name' and text()='Almera Rüzgarda Kırılmaz Tam Otomatik 8 Telli Şemsiye']");
}
