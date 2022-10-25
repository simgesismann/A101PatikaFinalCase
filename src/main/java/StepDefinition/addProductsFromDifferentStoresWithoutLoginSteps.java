package StepDefinition;
import Log.Log;
import PageObjectModel.Pages.CartPage;
import PageObjectModel.Pages.HomePage;
import PageObjectModel.Pages.ProductDetailPage;
import PageObjectModel.Pages.ProductsPage;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
public class addProductsFromDifferentStoresWithoutLoginSteps {
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    Log log;

    @Given("navigate to website")
    public void navigate_to_website() {
        driver = Driver.getDriver();
        log = new Log();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        log.info("Navigated to website.");
    }
    @And("type product name")
    public void type_product_name() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBarPage().typeProductNameInSearchBarText("şemsiye");
        log = new Log();
        log.info("Product name is typed in search bar.");
    }
    @And("type {string}")
    public void type(String productName) {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
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
        log.info("Product Details Page is directed.");
        productDetailPage.getTextOfProductName();
        productDetailPage.printProductName();
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        log.info("Add Cart Button is clicked.");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed.");
    }
    @And("add same product from another store to cart")
    public void add_same_product_from_another_store_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        log = new Log();
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        log.info("Other options of store are displayed on page.");
        productDetailPage.getTextTitleOfOtherOptionsList();
        productDetailPage.clickOtherOptionAddToCartButton();
        log.info("Other options' Add To Cart Button is clicked.");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed.");
    }
    @And("navigate to cart page")
    public void navigate_to_cart_page() {
        homePage = new HomePage(driver);
        log = new Log();
        homePage.clickToMyCart();
        log.info("My cart button is clicked to see products in it.");
    }
    @Then("confirm chosen products are on cart page")
    public void confirm_chosen_products_are_on_cart_page() {
        cartPage = new CartPage(driver);
        Driver driver1 = new Driver();
        cartPage.assertCartPageIsDirected();
        log.info("Cart Page is directed.");
        cartPage.getTextOfOtherFirmTitleInCartPage();
        cartPage.getTextOfProductNameInCartPage();
        cartPage.printProductNameInDetailPageAndCartPage();
        driver1.closeAllTabs();
        //cartPage.assertAddedProductFirmIsCorrectInCart();
    }
}
