package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPageConstants extends BasePage {
    public ProductDetailPageConstants(WebDriver driver) {
        super(driver);
    }
    public final By ProductIdLocator = By.id("product-name");
    public final By AddToCartButtonLocator = By.id("addToCart");
    public final By ProductIsAddedToCartTitleLocator = By.className("checkoutui-ProductOnBasketHeader-22Wrk");
    public final By CloseButtonLocator = By.className("checkoutui-Modal-2iZXl");
    public final By OtherBuyOptionsTitleLocator = By.className("otherBuyOptions");
    public final By OtherBuyOptionsListLocator = By.xpath("//*[@class=\"merchantStore small\"]");
    public final By AddToCartOtherBuyOptionButtonLocator = By.xpath("//*[@class=\"add-to-basket button small\"]");
}
