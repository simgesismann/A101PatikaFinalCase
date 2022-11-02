package TestNG;
import Log.Log;
import PageObjectModel.Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddProductsFromDifferentStoresWithLogin extends BaseTest{
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
    String productName;
    @BeforeMethod
    public void before(){
        homePage = new HomePage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        log = new Log();
        productName = "şemsiye";
    }
    @Test
    public void addProductsFromDifferentStoresWithLogin() throws InterruptedException {
        homePage.acceptCookies();
        homePage.moveAndClickLoginUserButton();
        loginPage.typeEmail();
        loginPage.clickLogInButton();
        loginPage.typePassword();
        loginPage.clickLoginButtonAfterPassword();
        homePage.assertUserLoggedIn();
        homePage.searchBarPage().typeProductNameInSearchBarText(productName);
        productsPage = homePage.searchBarPage().clickSearchButton();
        productsPage.assertProductPageIsDirected();
        productDetailPage = productsPage.chooseOneProduct();
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
        cartPage = homePage.clickToMyCartButton();
        cartPage.assertCartPageIsDirected();
        productNameInCartPage = cartPage.getTextOfProductNameInCartPage();
        productFirmNameInCartPage = cartPage.getTextOfOtherFirmTitleInCartPage().toUpperCase().replaceAll("\\p{M}", "");
        cartPage.assertAddedProductsAreSame();
    }
}
