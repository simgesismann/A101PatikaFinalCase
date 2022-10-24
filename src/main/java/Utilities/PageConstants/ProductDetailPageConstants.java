package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPageConstants extends BasePage {
    public ProductDetailPageConstants(WebDriver driver) {
        super(driver);
    }
    public final By AddToCartButtonLocator = By.id("addToCart");
    public final By ProductIsAddedToCartTitleLocator = By.className("checkoutui-ProductOnBasketHeader-22Wrk");
    public final By ContinueShoppingButtonLocator = By.linkText("Alışverişe devam et");
    public final By ProductIdLocator = By.id("product-name");
    public final By OtherBuyOptionsTitleLocator = By.className("otherBuyOptions");
    public final By OtherBuyOptionsListLocator = By.className("merchantStore-small");
    public final By AddToCartOtherBuyOptionButtonLocator = By.className("add-to-basket-button-small");
}
