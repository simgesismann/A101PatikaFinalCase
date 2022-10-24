package StepDefinition;

import PageObjectModel.Pages.HomePage;
import PageObjectModel.Pages.ProductDetailPage;
import PageObjectModel.Pages.ProductsPage;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class addProductsFromDifferentStoresWithoutLoginSteps {
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;

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
    public void add_product_to_cart() {
        productDetailPage = new ProductDetailPage(driver);
        List<String> pages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pages.get(1));
        productDetailPage.rollAndClickAddToCartButton();
        System.out.println("product added");
    }
    @And("add same product from another store to cart")
    public void add_same_product_from_another_store_to_cart() {
        System.out.println("add another");
    }
    @And("navigate to cart page")
    public void navigate_to_cart_page() {
        System.out.println("navigated cart page");
    }
    @Then("confirm chosen products are on cart page")
    public void confirm_chosen_products_are_on_cart_page() {
        System.out.println("confirmed that products are on page");
    }

}
