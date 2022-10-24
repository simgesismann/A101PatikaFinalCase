package PageObjectModel.Pages;

import Utilities.PageConstants.ProductDetailPageConstants;
import Utilities.PageConstants.ProductPagesConstants;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends ProductDetailPageConstants {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void rollAndClickAddToCartButton(){
        rollUntilFindElementAndClick(AddToCartButtonLocator);
    }
}
