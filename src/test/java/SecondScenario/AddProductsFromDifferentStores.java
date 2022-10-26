package SecondScenario;
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
    /**
     * Directed to Home Page
     * @method "typeProductNameInSearchBarText" is to type a word into search bar
     * @param "Text" is used to type in search bar.
     * @method "assertProductPageIsDirected" is confirm that page is directed by finding element
     * @method "chooseOneProduct" is a method to choose a product from list of search
     * @method "windowHandle" is to change window to operate other methods on it
     * @method "assertProductDetailPageIsDirected" is to confirm that page is directed by finding element
     * @method "rollAndClickAddToCartButton" is to scroll down to find element and click
     * @method "assertAddCartButtonIsClicked" is to confirm that button is clicked by finding element on pop-up
     * @method "clickCloseButton" is to close pop-up
     * @method "assertOtherBuyOptionsTitleIsDisplayed" is to confirm that product has other options of stores
     * @returns "getTextOfProductName" returns product's name in detail page
     * @returns  "getTextTitleOfOtherOptionsList" returns title of store name in detail page
     * @method "clickOtherOptionAddToCartButton" is to click AddToCartButton of other store
     * @method "clickToMyCartButton" is to direct MyCart
     * @returns "getTextOfProductNameInCartPage" returns product's name in cart page
     * @returns  "getTextOfOtherFirmTitleInCartPage" returns title of store name in cart page
     * @method "assertCartPageIsDirected" is to confirm that page is directed by finding element
     * @method "assertAddedProductsAreSame" is to confirm that user added same products
     */
    @Test(priority = 1)
    public void addProductsFromDifferentStoresWithoutLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        log = new Log();
        homePage.acceptCookies();
        log.info("Home page is directed.");
        homePage.searchBarPage().typeProductNameInSearchBarText("şemsiye");
        homePage.searchBarPage().clickSearchButton();
        log.info("Product name is searched.");
        productsPage.assertProductPageIsDirected();
        log.info("Product page is directed.");
        productsPage.chooseOneProduct();
        log.info("One of products is choosen.");
        productDetailPage.windowHandle();
        log.info("Window is handled.");
        productDetailPage.assertProductDetailPageIsDirected();
        log.info("Product detail page is directed.");
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        log.info("Scrolled down and AddToCart Button is clicked");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed");
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        log.info("Other stores options are displayed.");
        productNameInDetailPage = productDetailPage.getTextOfProductName();
        productFirmNameInDetailPage = productDetailPage.getTextTitleOfOtherOptionsList().toUpperCase().replaceAll("\\p{M}", "");
        productDetailPage.clickOtherOptionAddToCartButton();
        log.info("Other store's AddToCart Button is clicked.");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed");
        homePage.clickToMyCartButton();
        cartPage.assertCartPageIsDirected();
        log.info("Cart Page is directe.");
        productNameInCartPage = cartPage.getTextOfProductNameInCartPage();
        productFirmNameInCartPage = cartPage.getTextOfOtherFirmTitleInCartPage().toUpperCase().replaceAll("\\p{M}", "");
        cartPage.assertAddedProductsAreSame();
        log.info("In cart page, added products are same.");
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
        homePage.acceptCookies();
        log.info("Home page is directed.");
        homePage.moveAndClickCreateUserButton();
        log.info("Mouse is moved and click to User LogIn Button.");
        loginPage.typeEmail();
        loginPage.clickLogInButton();
        log.info("Mail is typed");
        loginPage.typePassword();
        loginPage.clickLoginButtonAfterPassword();
        log.info("Password is typed and login button is clicked.");
        homePage.assertUserLoggedIn();
        log.info("User is logged in.");
        homePage.searchBarPage().typeProductNameInSearchBarText("şemsiye");
        homePage.searchBarPage().clickSearchButton();
        log.info("Product name is searched.");
        productsPage.assertProductPageIsDirected();
        log.info("Product page is directed.");
        productsPage.chooseOneProduct();
        log.info("One of products is choosen.");
        productDetailPage.windowHandle();
        log.info("Window is handled.");
        productDetailPage.assertProductDetailPageIsDirected();
        log.info("Product detail page is directed.");
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        log.info("Scrolled down and AddToCart Button is clicked");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed");
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        log.info("Other stores options are displayed.");
        productNameInDetailPage = productDetailPage.getTextOfProductName();
        productFirmNameInDetailPage = productDetailPage.getTextTitleOfOtherOptionsList().toUpperCase().replaceAll("\\p{M}", "");
        productDetailPage.clickOtherOptionAddToCartButton();
        log.info("Other store's AddToCart Button is clicked.");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed");
        homePage.clickToMyCartButton();
        cartPage.assertCartPageIsDirected();
        log.info("Cart Page is directe.");
        productNameInCartPage = cartPage.getTextOfProductNameInCartPage();
        productFirmNameInCartPage = cartPage.getTextOfOtherFirmTitleInCartPage().toUpperCase().replaceAll("\\p{M}", "");
        cartPage.assertAddedProductsAreSame();
        log.info("In cart page, added products are same.");
        Assertions.assertEquals(productFirmNameInCartPage, productFirmNameInDetailPage);
        log.info("Product firm in ProductDetailPage is confirmed in CartPage");
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
        log.info("Product name in ProductDetailPage is confirmed in CartPage");
    }
}
