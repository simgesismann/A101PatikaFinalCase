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
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
public class addProductsFromDifferentStores {
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    Log log;
    String productNameInDetailPage ;
    String productNameInCartPage ;
    String productFirmNameInCartPage ;
    String productFirmNameInDetailPage ;
    /**
     * Directed to Home Page
     */
    @Given("navigate to website")
    public void navigate_to_website() {
        driver = Driver.getDriver();
        log = new Log();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        log.info("Navigated to website.");
    }
    @Given("user log in")
    public void user_log_in() {
        homePage = new HomePage(driver);
        //homePage.moveAndClickCreateUserButton();

    }
    @And("confirm user is logged in")
    public void confirm_user_is_logged_in() {

    }
    /**
     * Directed to Home Page
     * @param "Text" is used to type in search bar.
     */
    @And("type {string}")
    public void type(String productName) {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBarPage().typeProductNameInSearchBarText(productName);
        log = new Log();
        log.info("Product name is typed in search bar.");
    }
    /**
     * Search button in searchbar is clicked.
     */
    @And("search product")
    public void search_product() {
        homePage = new HomePage(driver);
        homePage.searchBarPage().clickSearchButton();
        log = new Log();
        log.info("Product is searching.");
    }
    /**
     * After search , in product page there are products.
     * First one of that product list is chosen.
     */
    @And("choose a product")
    public void choose_a_product() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        log = new Log();
        productsPage.assertProductPageIsDirected();
        log.info("Product page is directed.");
        productsPage.chooseOneProduct();
        log.info("A product from list is chosen.");
    }
    /**
     * When product is chosen new tab is opened and navigated to it.
     * Assert that detail page is directed or not.
     * @method "rollAndClickAddToCartButton()" is to scroll down until find ADD TO CART BUTTON.
     * Assert that cart button is clicked.
     * When ADD TO CART button is clicked, there is pop-up.
     * @method "clickCloseButton()" is to close Pop-up.
     */
    @And("add product to cart")
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        log = new Log();
        productDetailPage.windowHandle();
        log.info("Window is handled.");
        productDetailPage.assertProductDetailPageIsDirected();
        log.info("Product Details Page is directed.");
        productFirmNameInDetailPage = productDetailPage.getTextTitleOfOtherOptionsList();
        productNameInDetailPage = productDetailPage.getTextOfProductName();
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        log.info("Add Cart Button is clicked.");
        productDetailPage.clickCloseButton();
        log.info("Pop-up is closed.");
    }
    /**
     * @method "assertOtherBuyOptionsTitleIsDisplayed()" is to confirm that product has other option firms.
     * Click first ADD TO CART Button in other options
     * @method "clickCloseButton()" is to close Pop-up.
     */
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
    /**
     * @method "clickToMyCard" is to navigate cart page.
     */
    @And("navigate to cart page")
    public void navigate_to_cart_page() {
        homePage = new HomePage(driver);
        log = new Log();
        homePage.clickToMyCartButton();
        log.info("My cart button is clicked to see products in it.");
    }
    /**
     * Confirm that page is directed
     *
     */
    @Then("confirm chosen products are on cart page")
    public void confirm_chosen_products_are_on_cart_page() {
        cartPage = new CartPage(driver);
        Driver driver1 = new Driver();
        cartPage.assertCartPageIsDirected();
        log.info("Cart Page is directed.");
        productFirmNameInCartPage = cartPage.getTextOfOtherFirmTitleInCartPage().replaceAll("\\p{M}", "");;
        productNameInCartPage = cartPage.getTextOfProductNameInCartPage();
        Assertions.assertEquals(productFirmNameInCartPage.toUpperCase(),productFirmNameInDetailPage.toUpperCase());
        Assertions.assertTrue(productNameInCartPage.contains(productNameInDetailPage));
        driver1.closeAllTabs();
    }
}
