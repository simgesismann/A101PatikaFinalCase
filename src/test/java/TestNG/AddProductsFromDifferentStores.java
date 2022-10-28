package TestNG;
import Log.Log;
import PageObjectModel.Pages.*;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
/**
 * This class tests addition products from different stores.
 *  @author Simge ŞİŞMAN
 */
public class AddProductsFromDifferentStores extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    LoginPage loginPage;
    Log log;
    String productFirmNameInDetailPage;
    String productFirmNameInCartPage;
    String productNameInDetailPage;
    String productNameInCartPage;

    @Test(priority = 1)
    public void addProductsFromDifferentStoresWithoutLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        log = new Log();
        homePage.acceptCookies();
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
        Assertions.assertEquals(productFirmNameInCartPage, productFirmNameInDetailPage);
        log.info("Product firm in ProductDetailPage is confirmed in CartPage");
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
        log.info("Product name in ProductDetailPage is confirmed in CartPage");
    }
    @Test(priority=2)
    public void addProductsFromDifferentStoresWithLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        log = new Log();
        homePage.acceptCookies();
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
