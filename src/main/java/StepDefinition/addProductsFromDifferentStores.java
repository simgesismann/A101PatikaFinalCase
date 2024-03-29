package StepDefinition;
import Log.Log;
import PageObjectModel.Pages.*;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
public class addProductsFromDifferentStores {
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
    @Given("navigate to website")
    public void navigate_to_website() {
        driver = Driver.getDriver();
        log = new Log();
        log.info("---BDD Test is initialized---");
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        log.info("Navigated to website.");
    }
    @Given("user log in")
    public void user_log_in() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.moveAndClickLoginUserButton();
        loginPage.typeEmail();
        loginPage.clickLogInButton();
        loginPage.typePassword();
        loginPage.clickLoginButtonAfterPassword();
    }
    @And("confirm user is logged in")
    public void confirm_user_is_logged_in() {
        homePage = new HomePage(driver);
        homePage.assertUserLoggedIn();
    }
    @And("accept cookies")
    public void acceptCookies(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }
    @And("type {string}")
    public void type(String productName) {
        homePage = new HomePage(driver);
        homePage.searchBarPage().typeProductNameInSearchBarText(productName);
    }
    @And("search product")
    public void search_product() {
        homePage = new HomePage(driver);
        productsPage = homePage.searchBarPage().clickSearchButton();
    }
    @And("choose a product")
    public void choose_a_product() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        productsPage.assertProductPageIsDirected();
        productDetailPage = productsPage.chooseOneProduct();
    }
    @And("add product to cart")
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        log = new Log();
        productDetailPage.windowHandle();
        productDetailPage.assertProductDetailPageIsDirected();
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        productDetailPage.clickCloseButton();
    }
    @And("add same product from another store to cart")
    public void add_same_product_from_another_store_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        productNameInDetailPage = productDetailPage.getTextOfProductName();
        productFirmNameInDetailPage = productDetailPage.getTextTitleOfOtherOptionsList().toUpperCase().replaceAll("\\p{M}", "");
        productDetailPage.clickOtherOptionAddToCartButton();
        productDetailPage.clickCloseButton();
    }
    @And("navigate to cart page")
    public void navigate_to_cart_page() {
        homePage = new HomePage(driver);
        log = new Log();
        cartPage = new CartPage(driver);
        cartPage = homePage.clickToMyCartButton();
        cartPage.assertCartPageIsDirected();
    }
    @And("confirm product chosen from another store is on cart page")
    public void confirmProductChosenFromAnotherStoreIsOnCartPage(){
        cartPage = new CartPage(driver);
        productNameInCartPage = cartPage.getTextOfProductNameInCartPage();
        productFirmNameInCartPage = cartPage.getTextOfOtherFirmTitleInCartPage().toUpperCase().replaceAll("\\p{M}", "");
        Assertions.assertEquals(productFirmNameInCartPage, productFirmNameInDetailPage);
        log.info("Product firm in ProductDetailPage is confirmed in CartPage");
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
        log.info("Product name in ProductDetailPage is confirmed in CartPage");
    }
    @Then("confirm chosen products are on cart page")
    public void confirm_chosen_products_are_on_cart_page() {
        cartPage = new CartPage(driver);
        cartPage.assertAddedProductsAreSame();
    }

    @Then("close all tabs")
    public void closeAllTabs(){
        log = new Log();
        log.info("---BDD TEST END, Closing all tabs---");
        Driver driver1 = new Driver();
        driver1.closeAllTabs();
    }
}
