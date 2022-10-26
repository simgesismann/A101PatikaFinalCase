package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageConstants extends BasePage {
    public CartPageConstants(WebDriver driver) {
        super(driver);
    }
    public By CartHeaderTitleLocator = By.className("basket_headerTop_15H0U");
    public By OtherFirmTitleInCartPageLocator = By.className("merchantLink_2Ii8s");
    public By ProductNameInCartPageLocator = By.className("product_name_3Lh3t");
}
