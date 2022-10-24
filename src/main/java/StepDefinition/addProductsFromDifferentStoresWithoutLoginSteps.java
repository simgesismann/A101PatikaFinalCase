package StepDefinition;
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

    @Given("navigate to website")
    public void navigate_to_website() {
        driver = Driver.getDriver();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
    }
    @And("type product name")
    public void type_product_name() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBarPage().typeProductNameInSearchBarText();
        System.out.println("typed");
    }
    @And("search product")
    public void search_product() {
        homePage = new HomePage(driver);
        homePage.searchBarPage().clickSearchButton();
        System.out.println("searched");
    }
    @And("choose a product")
    public void choose_a_product() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        productsPage.assertProductPageIsDirected();
        productsPage.chooseOneProduct();
        System.out.println("choosed");
    }
    @And("add product to cart")
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.windowHandle();
        productDetailPage.assertProductDetailPageIsDirected();
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        productDetailPage.clickCloseButton();
        System.out.println("product added");
    }
    @And("add same product from another store to cart")
    public void add_same_product_from_another_store_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        productDetailPage.getTextTitleOfOtherOptionsList();
        productDetailPage.clickOtherOptionAddToCartButton();
        productDetailPage.clickCloseButton();
        System.out.println("add another");
    }
    @And("navigate to cart page")
    public void navigate_to_cart_page() {
        homePage = new HomePage(driver);
        homePage.clickToMyCart();
        System.out.println("navigated cart page");
    }
    @Then("confirm chosen products are on cart page")
    public void confirm_chosen_products_are_on_cart_page() {
        cartPage = new CartPage(driver);
        cartPage.assertCartPageIsDirected();
        cartPage.getTextOfOtherFirmTitleInCartPage();
        cartPage.assertAddedProductFirmIsCorrectInCart();
        System.out.println("confirmed that products are on page");
    }
}
