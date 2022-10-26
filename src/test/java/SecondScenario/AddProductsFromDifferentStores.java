package SecondScenario;
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
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
    }
    @Test(priority=2)
    public void addProductsFromDifferentStoresWithLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        homePage.acceptCookies();
        homePage.moveAndClickCreateUserButton();
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
        Assertions.assertEquals(productFirmNameInCartPage, productFirmNameInDetailPage);
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
    }
}
