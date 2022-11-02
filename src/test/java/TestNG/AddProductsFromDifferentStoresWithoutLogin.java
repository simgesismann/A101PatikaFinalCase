package TestNG;
import Log.Log;
import PageObjectModel.Pages.*;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * This class tests addition products from different stores.
 *  @author Simge ŞİŞMAN
 */
public class AddProductsFromDifferentStoresWithoutLogin extends BaseTest{
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
    String productName ;
    @BeforeMethod
    public void before(){
        homePage = new HomePage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        log = new Log();
        productName = "şemsiye";
    }
    @Test
    public void addProductsFromDifferentStoresWithoutLogin() throws InterruptedException {
        homePage.acceptCookies();
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
        Assertions.assertEquals(productFirmNameInCartPage, productFirmNameInDetailPage);
        log.info("Product firm in ProductDetailPage is confirmed in CartPage");
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
        log.info("Product name in ProductDetailPage is confirmed in CartPage");
    }

}
