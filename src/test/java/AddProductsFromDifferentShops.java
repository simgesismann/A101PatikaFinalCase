import PageObjectModel.Pages.CartPage;
import PageObjectModel.Pages.HomePage;
import PageObjectModel.Pages.ProductDetailPage;
import PageObjectModel.Pages.ProductsPage;
import org.testng.annotations.Test;

public class AddProductsFromDifferentShops extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    @Test(priority = 1)
    public void typeProductName() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBarPage().typeProductNameInSearchBarText();
        System.out.println("typed");
    }
    @Test(priority = 2)
    public void searchProduct() {
        homePage = new HomePage(driver);
        homePage.searchBarPage().clickSearchButton();
        System.out.println("searched");
    }
    @Test(priority = 3)
    public void chooseProduct() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        productsPage.assertProductPageIsDirected();
        productsPage.chooseOneProduct();
        System.out.println("choosed");
    }
    @Test(priority = 4)
    public void addProductToCart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.windowHandle();
        productDetailPage.assertProductDetailPageIsDirected();
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        productDetailPage.clickCloseButton();
        System.out.println("product added");
    }
    @Test(priority = 5)
    public void addSameProductFromAnotherStoreToCart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        productDetailPage.getTextTitleOfOtherOptionsList();
        productDetailPage.clickOtherOptionAddToCartButton();
        productDetailPage.clickCloseButton();
        System.out.println("add another");
    }
    @Test(priority = 6)
    public void navigateToCartPage() {
        homePage = new HomePage(driver);
        homePage.clickToMyCart();
        System.out.println("navigated cart page");
    }
    @Test(priority = 7)
    public void confirmChosenProductsAreOnCartPage() {
        cartPage = new CartPage(driver);
        cartPage.assertCartPageIsDirected();
        cartPage.getTextOfOtherFirmTitleInCartPage();
        cartPage.assertAddedProductFirmIsCorrectInCart();
        System.out.println("confirmed that products are on page");
    }
}
