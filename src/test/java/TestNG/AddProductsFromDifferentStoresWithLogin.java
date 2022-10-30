package TestNG;

import Log.Log;
import PageObjectModel.Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddProductsFromDifferentStoresWithLogin extends BaseTest{
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    LoginPage loginPage;
    Log log;
    String productNameInDetailPage ;
    String productNameInCartPage ;
    String productFirmNameInCartPage ;
    String productFirmNameInDetailPage ;
    @Test
    public void addProductsFromDifferentStoresWithLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        log = new Log();
        //homePage.acceptCookies();
        homePage.moveAndClickLoginUserButton();
        loginPage.typeEmail();
        loginPage.clickLogInButton();
        loginPage.typePassword();
        loginPage.clickLoginButtonAfterPassword();
        homePage.assertUserLoggedIn();
        homePage.searchBarPage().typeProductNameInSearchBarText("şemsiye");
        homePage.searchBarPage().clickSearchButton();
        productsPage.assertProductPageIsDirected();
        productsPage.chooseOneProduct();
        productDetailPage.windowHandle();
        productDetailPage.assertProductDetailPageIsDirected();
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        productDetailPage.clickCloseButton();
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        productNameInDetailPage = productDetailPage.getTextOfProductName();
        productFirmNameInDetailPage = productDetailPage.getTextTitleOfOtherOptionsList().toUpperCase().replaceAll("\\p{M}", "");
        productDetailPage.clickOtherOptionAddToCartButton();
        productDetailPage.clickCloseButton();
        homePage.clickToMyCartButton();
        cartPage.assertCartPageIsDirected();
        productNameInCartPage = cartPage.getTextOfProductNameInCartPage();
        productFirmNameInCartPage = cartPage.getTextOfOtherFirmTitleInCartPage().toUpperCase().replaceAll("\\p{M}", "");
        cartPage.assertAddedProductsAreSame();
    }
}
