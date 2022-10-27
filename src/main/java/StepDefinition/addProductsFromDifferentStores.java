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
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        log.info("Navigated to website.");
        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }
    @Given("user log in")
    public void user_log_in() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.moveAndClickLoginUserButton();
        log.info("Mouse is moved and click to User LogIn Button.");
        loginPage.typeEmail();
        loginPage.clickLogInButton();
        log.info("Mail is typed");
        loginPage.typePassword();
        loginPage.clickLoginButtonAfterPassword();
        log.info("Password is typed and login button is clicked.");

    }
    @And("confirm user is logged in")
    public void confirm_user_is_logged_in() {
        homePage = new HomePage(driver);
        homePage.assertUserLoggedIn();
        log.info("User is logged in.");
    }
    @And("type {string}")
    public void type(String productName) {
        homePage.searchBarPage().typeProductNameInSearchBarText(productName);
        log = new Log();
        log.info("Product name is typed in search bar.");
    }
    @And("search product")
    public void search_product() {
        homePage = new HomePage(driver);
        homePage.searchBarPage().clickSearchButton();
        log = new Log();
        log.info("Product is searching.");
    }
    @And("choose a product")
    public void choose_a_product() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        log = new Log();
        productsPage.assertProductPageIsDirected();
        log.info("Product page is directed.");
        productsPage.chooseOneProduct();
        log.info("A product from list is chosen.");
    }
    @And("add product to cart")
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        log = new Log();
        productDetailPage.windowHandle();
        log.info("Window is handled.");
        productDetailPage.assertProductDetailPageIsDirected();
        log.info("Product detail page is directed.");
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        log.info("Scrolled down and AddToCart Button is clicked");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed");
    }
    @And("add same product from another store to cart")
    public void add_same_product_from_another_store_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        log = new Log();
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        log.info("Other stores options are displayed.");
        productNameInDetailPage = productDetailPage.getTextOfProductName();
        productFirmNameInDetailPage = productDetailPage.getTextTitleOfOtherOptionsList().toUpperCase().replaceAll("\\p{M}", "");
        productDetailPage.clickOtherOptionAddToCartButton();
        log.info("Other store's AddToCart Button is clicked.");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed");
    }
    @And("navigate to cart page")
    public void navigate_to_cart_page() {
        homePage = new HomePage(driver);
        log = new Log();
        cartPage = new CartPage(driver);
        homePage.clickToMyCartButton();
        cartPage.assertCartPageIsDirected();
        log.info("Cart Page is directed.");
    }
    @Then("confirm chosen products are on cart page")
    public void confirm_chosen_products_are_on_cart_page() {
        cartPage = new CartPage(driver);
        productNameInCartPage = cartPage.getTextOfProductNameInCartPage();
        productFirmNameInCartPage = cartPage.getTextOfOtherFirmTitleInCartPage().toUpperCase().replaceAll("\\p{M}", "");
        cartPage.assertAddedProductsAreSame();
        log.info("In cart page, added products are same.");
        Assertions.assertEquals(productFirmNameInCartPage, productFirmNameInDetailPage);
        log.info("Product firm in ProductDetailPage is confirmed in CartPage");
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
        log.info("Product name in ProductDetailPage is confirmed in CartPage");
    }
    @Then("close all tabs")
    public void closeAllTabs(){
        Driver driver1 = new Driver();
        driver1.closeAllTabs();
    }
}
